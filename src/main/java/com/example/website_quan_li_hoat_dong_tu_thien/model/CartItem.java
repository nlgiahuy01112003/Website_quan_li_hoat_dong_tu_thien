package com.example.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Table(name = "CartItem")
@RequiredArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARTITEM")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_EVENT")
    private Event event;

    @Column(name = "QUANTITY", nullable = false)
    private int quantity;

    public CartItem(Event event, int quantity) {
        this.event = event;
        this.quantity = quantity;
    }
}
