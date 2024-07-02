package com.example.community.Services.impl;

import com.example.community.Entity.Order;
import com.example.community.Entity.UserEntity;
import com.example.community.Services.OrderService;
import com.example.community.repos.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
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
        order = orderRepository.save(order);

        return order;
    }
    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }


}


