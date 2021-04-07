package com.takeaway.demo.service;

import com.takeaway.demo.dao.CustomerRepository;
import com.takeaway.demo.entity.Customer;
import com.takeaway.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//business logic
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //save customer
    public Customer saveCustomer(Customer customer){
        if(!customerRepository.findByCustomerEmail(customer.getEmail()).isEmpty()){

            //if customer is already present
            System.out.println("Customer already created");

        }else{

            //otherwise save customer
            return customerRepository.save(customer);
        }

        return customer;
    }

    //save list of customers
    public List<Customer> saveCustomers(List<Customer> customers){
        return customerRepository.saveAll(customers);
    }

    //get all customers from database
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    //get customer by id
    public Customer getCustomerById(Long id){
        return this.customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + id));
    }

    //get customer by email
    public Customer getCustomerByEmail(String theEmail){
        return customerRepository.findByEmail(theEmail);
    }

    //delete customer
    public String deleteCustomer(Long id){
        customerRepository.deleteById(id);
        return "Customer " + id +" deleted.";
    }

    //update customer
    public Customer updateCustomer(Customer customer){
        Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        return customerRepository.save(existingCustomer);
    }
}
