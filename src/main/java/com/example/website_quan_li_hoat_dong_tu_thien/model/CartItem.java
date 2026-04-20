package com.example.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CartItem")
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

    public CartItem() {}

    public CartItem(Event event, int quantity) {
        this.event = event;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
