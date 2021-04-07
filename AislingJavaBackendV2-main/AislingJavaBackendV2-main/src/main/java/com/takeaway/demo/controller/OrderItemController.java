package com.takeaway.demo.controller;

import com.takeaway.demo.entity.OrderItem;
import com.takeaway.demo.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//api's
//talks to OrderItemService class
@RestController
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    //get OrderItem by dish id
    @GetMapping("/orderItem/{dishId}")
    public OrderItem findOrderItemById(@PathVariable Long dishId){
        return orderItemService.getOrderItemById(dishId);
    }

}//end class
