package com.takeaway.demo.service;

import com.takeaway.demo.dao.OrderItemRepository;
import com.takeaway.demo.entity.OrderItem;
import com.takeaway.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    //check for dish id in database
    //if not present notify user
    public OrderItem getOrderItemById(Long dishId){
        return this.orderItemRepository.findById(dishId).orElseThrow(() -> new ResourceNotFoundException("Dish not found: " + dishId));
    }

}//end class
