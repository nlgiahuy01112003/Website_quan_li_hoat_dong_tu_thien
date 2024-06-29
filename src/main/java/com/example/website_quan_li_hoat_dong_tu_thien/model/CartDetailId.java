package com.example.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailId implements Serializable {
    private Long cartId;
    private Long eventId; // Đổi tên từ productId thành eventId

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
