package com.example.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "order_events")
public class OrderEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @OneToMany(mappedBy = "order")
    private List<OrderEventDetail> orderDetails;

    public OrderEvent() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public List<OrderEventDetail> getOrderDetails() { return orderDetails; }
    public void setOrderDetails(List<OrderEventDetail> orderDetails) { this.orderDetails = orderDetails; }
}
