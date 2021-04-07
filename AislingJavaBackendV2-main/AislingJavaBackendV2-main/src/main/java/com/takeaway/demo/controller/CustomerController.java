package com.takeaway.demo.controller;

import com.takeaway.demo.entity.Customer;
import com.takeaway.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //add a customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    //add list of customers
    @PostMapping("/customers")
    public List<Customer> addCustomer(@RequestBody List<Customer> customers){
        return customerService.saveCustomers(customers);
    }

    //get all customers in database
    @GetMapping("/customers")
    public List<Customer> findAllCustomers(){
        return customerService.getCustomers();
    }

    //get customer by id
    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    //get customer by email
    @GetMapping("/customers/{email}")
    public Customer findCustomerByEmail(String theEmail){
        return customerService.getCustomerByEmail(theEmail);
    }

    //update a review
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    //delete a customer
    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }

}//end class
