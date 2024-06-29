package com.example.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "order_event_details")
@RequiredArgsConstructor
public class OrderEventDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEvent order;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}
