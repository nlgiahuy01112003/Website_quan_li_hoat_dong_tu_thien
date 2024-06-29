package com.example.website_quan_li_hoat_dong_tu_thien.repository;

import com.example.website_quan_li_hoat_dong_tu_thien.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}