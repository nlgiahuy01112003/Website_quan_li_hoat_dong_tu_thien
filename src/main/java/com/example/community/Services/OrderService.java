package com.example.community.Services;

import com.example.community.Entity.Order;
import com.example.community.dto.ProjetDto;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrders();
}
