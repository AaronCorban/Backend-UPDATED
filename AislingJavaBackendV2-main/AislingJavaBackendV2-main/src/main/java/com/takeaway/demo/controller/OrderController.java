package com.takeaway.demo.controller;

import com.takeaway.demo.entity.Order;
import com.takeaway.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//api's
//talks to OrderService class
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    //add a order
    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    //get all orders in database
    @GetMapping("/orders")
    public List<Order> findAllOrders(){
        return orderService.getOrders();
    }

    //get order by id
    @GetMapping("/orders/{id}")
    public Order findOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    //delete an order by id
    @DeleteMapping("/orders/{id}")
    public String deleteReview(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }

    //update an order
    @PutMapping("/orders/{id}")
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

}//end class
