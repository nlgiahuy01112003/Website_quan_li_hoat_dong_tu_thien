package com.example.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Data
@Entity
@Table(name = "order_events")
@RequiredArgsConstructor
public class OrderEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @OneToMany(mappedBy = "order")
    private List<OrderEventDetail> orderDetails;
}
