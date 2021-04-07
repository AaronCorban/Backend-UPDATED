package com.takeaway.demo.dao;

import com.takeaway.demo.entity.Customer;
import com.takeaway.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //to find one customer
    Customer findByEmail(String theEmail);

    //to check all customers
    List<Customer> findByCustomerEmail(String theEmail);

}
