package app.controller;

import app.entity.Customer;
import app.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//@RequestMapping("/")
public class ModelViewHomeController {

    private CustomerService customerService;
;

    public ModelViewHomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public String postName(@ModelAttribute Customer customer) {
        System.out.println(customer.getCustomerNumber());
        System.out.println(customer.getName());
        System.out.println(customer.getAge());
        System.out.println(customer.getCity());
        return "createCustomer";
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/customerList")
    public ModelAndView getCustomerList(ModelAndView model) {
//        model.setViewName("customerList");
//        model.addObject("ListOfCustomers", customerService.getAllCustomer());
//        model.addAttribute()
        return model;
    }

    @GetMapping("/createCustomer")
    public ModelAndView showDesignForm(ModelAndView model) {
        model.setViewName("createCustomer");
        model.addObject("customer", new Customer());
        return model; // название .html страницы
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/customerList";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam String customerNumber) {
        customerService.deleteCustomer(Long.valueOf(customerNumber));
        return "redirect:/customerList";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:/customerList";
    }

    @GetMapping("/editUser")
    public ModelAndView editUser(@RequestParam String customerNumber, ModelAndView model) {
        Customer customerFoEdit = customerService.getById(customerNumber);
        model.setViewName("editUser");
        model.addObject("customer", customerFoEdit);
        return model;
    }
}
