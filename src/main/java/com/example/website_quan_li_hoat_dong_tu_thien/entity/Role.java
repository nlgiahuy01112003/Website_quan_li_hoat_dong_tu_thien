package com.example.website_quan_li_hoat_dong_tu_thien.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users = new ArrayList<>();

    public Role() {}

    public Role(Long id, String name, List<UserEntity> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<UserEntity> getUsers() { return users; }
    public void setUsers(List<UserEntity> users) { this.users = users; }
}
