package com.example.website_quan_li_hoat_dong_tu_thien.repository;

import com.example.website_quan_li_hoat_dong_tu_thien.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
