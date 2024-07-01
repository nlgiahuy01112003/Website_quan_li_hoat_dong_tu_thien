package com.example.community.Services;

import com.example.community.Entity.Order;
import com.example.community.repos.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Transactional
    public Order createOrder(String customerName, String phone, String address, String email, String note) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setPhone(phone);
        order.setAddress(address);
        order.setEmail(email);
        order.setNote(note);

        return order;
    }
}

