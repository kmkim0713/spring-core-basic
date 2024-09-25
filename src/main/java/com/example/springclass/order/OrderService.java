package com.example.springclass.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
