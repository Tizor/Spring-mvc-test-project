package app.service;

import app.entity.Customer;

public interface CustomerService {
    Iterable<Customer> getAllCustomer();
    void createCustomer(Customer customer);
    void deleteCustomer(Long id);
    void updateCustomer(Customer customer);
    Customer getById(String id);
}
