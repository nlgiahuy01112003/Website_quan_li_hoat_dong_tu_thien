package com.example.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.Embeddable;


import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartDetailId implements Serializable {
    private Long cartId;
    private Long eventId;

    public CartDetailId() {}

    public CartDetailId(Long cartId, Long eventId) {
        this.cartId = cartId;
        this.eventId = eventId;
    }

    public Long getCartId() { return cartId; }
    public void setCartId(Long cartId) { this.cartId = cartId; }
    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartDetailId)) return false;
        CartDetailId that = (CartDetailId) o;
        return Objects.equals(getCartId(), that.getCartId()) &&
                Objects.equals(getEventId(), that.getEventId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCartId(), getEventId());
    }
}
