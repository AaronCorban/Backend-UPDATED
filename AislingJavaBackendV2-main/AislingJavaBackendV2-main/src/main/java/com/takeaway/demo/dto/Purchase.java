package com.takeaway.demo.dto;

import com.takeaway.demo.entity.Address;
import com.takeaway.demo.entity.Customer;
import com.takeaway.demo.entity.Order;
import com.takeaway.demo.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
