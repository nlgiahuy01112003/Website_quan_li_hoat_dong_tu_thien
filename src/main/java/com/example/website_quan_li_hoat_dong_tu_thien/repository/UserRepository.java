package com.example.website_quan_li_hoat_dong_tu_thien.repository;


import com.example.website_quan_li_hoat_dong_tu_thien.entity.UserEntity; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String userName);
    UserEntity findFirstByUsername(String username);
}
