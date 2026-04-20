package com.example.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Cart_Detail")
public class CartDetail {
    @EmbeddedId
    private CartDetailId id;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "ID_CART")
    private Cart cart;

    @ManyToOne
    @MapsId("eventId")
    @JoinColumn(name = "ID_EVENT")
    private Event event;

    @Column(name = "SOLD_NUM", nullable = false)
    private int soldNum;

    @Column(name = "META")
    private String meta;

    @Column(name = "`ORDER`", nullable = false)
    private int order;

    @Column(name = "LINK")
    private String link;

    @Column(name = "HIDE", nullable = false)
    private boolean hide;

    public CartDetail() {}

    public CartDetailId getId() { return id; }
    public void setId(CartDetailId id) { this.id = id; }
    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }
    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
    public int getSoldNum() { return soldNum; }
    public void setSoldNum(int soldNum) { this.soldNum = soldNum; }
    public String getMeta() { return meta; }
    public void setMeta(String meta) { this.meta = meta; }
    public int getOrder() { return order; }
    public void setOrder(int order) { this.order = order; }
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
    public boolean isHide() { return hide; }
    public void setHide(boolean hide) { this.hide = hide; }
}
