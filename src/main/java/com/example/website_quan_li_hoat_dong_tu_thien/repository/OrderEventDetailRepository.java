package com.example.website_quan_li_hoat_dong_tu_thien.repository;

import com.example.website_quan_li_hoat_dong_tu_thien.model.OrderEventDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderEventDetailRepository extends JpaRepository<OrderEventDetail, Long> {
}