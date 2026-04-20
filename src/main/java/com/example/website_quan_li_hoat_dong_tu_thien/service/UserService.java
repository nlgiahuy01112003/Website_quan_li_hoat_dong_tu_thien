package com.example.website_quan_li_hoat_dong_tu_thien.service;

import com.example.website_quan_li_hoat_dong_tu_thien.entity.UserEntity;
import com.example.website_quan_li_hoat_dong_tu_thien.dto.RegistrationDto;

import java.util.List;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    List<UserEntity> findAllUsers();
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}
