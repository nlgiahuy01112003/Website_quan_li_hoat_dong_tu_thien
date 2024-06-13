package com.group_eight.website_quan_li_hoat_dong_tu_thien.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;
    private boolean enabled;

    @OneToMany(mappedBy = "user")
    private List<Donation> donations;

    @OneToMany(mappedBy = "user")
    private List<Expense> expenses;

    @OneToMany(mappedBy = "user")
    private List<Volunteer> volunteers;

    public String getVerificationCode() {
        return id.toString();
    }
}