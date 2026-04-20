package com.example.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;


@Entity
@Table(name = "order_event_details")
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

    public OrderEventDetail() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public OrderEvent getOrder() { return order; }
    public void setOrder(OrderEvent order) { this.order = order; }
    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
