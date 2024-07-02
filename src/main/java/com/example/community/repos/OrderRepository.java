package com.example.community.repos;

import com.example.community.Entity.Order;
import com.example.community.dto.ProjetDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();
}
