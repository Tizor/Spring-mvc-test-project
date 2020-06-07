package app.service;

import app.entity.Customer;
import app.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer getById(String id) {
        Optional<Customer> optional = customerRepository.findById(Long.valueOf(id));
        return optional.get();
    }

    @Transactional
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);

    }
    @Transactional
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    public Iterable<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
