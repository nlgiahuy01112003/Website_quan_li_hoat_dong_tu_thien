package com.example.website_quan_li_hoat_dong_tu_thien;

public enum Role {
    ADMIN(1),
    USER(2);
    public final long value;
    Role(long value) {
        this.value = value;
    }
}