package app.controller;

import app.entity.Customer;
import app.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private CustomerService customerService;

    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public String postName(@ModelAttribute Customer customer) {
        return "createCustomer";
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/customerInfo")
    public String getCustomerInfo(@RequestParam String customerNumber, Model model) {
        model.addAttribute("customerInfo", customerService.getById(customerNumber));
        return "customerInfo";
    }

    @GetMapping("/customerList")
    public String getCustomerList(Model model) {
        model.addAttribute("ListOfCustomers", customerService.getAllCustomer());
        return "customerList";
    }

    @GetMapping("/customerListFromList")
    public String getCustomerListFromList(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("castList", customerService.getAllCustomer());
        return "customerList";
    }

    @GetMapping("/createCustomer")
    public String showDesignForm(@ModelAttribute Customer customer, Model model) {
        List<String> professionList = Arrays.asList("King Killer", "Boss", "Small man", "Brother love", "No one");
        model.addAttribute("customer", new Customer());
        model.addAttribute("professionList", professionList);
        return "createCustomer"; // название .html страницы
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
    public String updateCustomer(@ModelAttribute Customer customer) { // @ModelAttribute в аргументах метода используется в случае когда нужно взять данные для сущности с вида .html
        customerService.updateCustomer(customer);
        return "redirect:/customerList";
    }

    @GetMapping("/editUser")
    public String editUser(@RequestParam String customerNumber, Model model) {
        List<String> professionList = Arrays.asList("King Killer", "Boss", "Small man", "Brother love", "No one");
        Customer customerFoEdit = customerService.getById(customerNumber);
        model.addAttribute("professionList", professionList);
        model.addAttribute("customer", customerFoEdit);
        return "editUser";
    }

}
