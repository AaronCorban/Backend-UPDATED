package com.takeaway.demo.dao;

import com.takeaway.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderTrackingNumber(String orderTrackingNumber);
}
