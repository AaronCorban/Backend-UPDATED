package com.takeaway.demo.service;

import com.takeaway.demo.dao.OrderRepository;
import com.takeaway.demo.entity.Order;
import com.takeaway.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//business logic
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    //save order
    public Order saveOrder(Order order){
        if(!orderRepository.findByOrderTrackingNumber(order.getOrderTrackingNumber()).isEmpty()){

            //if oder is already present
            System.out.println("Order already stored");

        }else {

            //otherwise save order
            return orderRepository.save(order);
        }

        return order;
    }

    //get all orders from database
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    //get order by id
    public Order getOrderById(Long id){
        return this.orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found: " + id));
    }

    //delete order by id
    public String deleteOrder(Long id){
        orderRepository.deleteById(id);
        return "Order " + id +" deleted.";
    }

    //update order status
    public Order updateOrder(Order order){
        Order existingOrder = orderRepository.findById(order.getId()).orElse(null);
        existingOrder.setStatus(order.getStatus());
        return orderRepository.save(existingOrder);
    }
}//end class
