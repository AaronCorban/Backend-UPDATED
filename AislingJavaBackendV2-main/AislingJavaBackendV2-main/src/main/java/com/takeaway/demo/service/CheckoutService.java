package com.takeaway.demo.service;

import com.takeaway.demo.dto.Purchase;
import com.takeaway.demo.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
