package com.example.community.Services;


import com.example.community.Entity.UserEntity;
import com.example.community.dto.RegistrationDto;

import java.util.List;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    List<UserEntity> findAllUsers();

    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);


}
