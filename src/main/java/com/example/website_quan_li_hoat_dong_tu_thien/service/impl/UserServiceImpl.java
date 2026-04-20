package com.example.website_quan_li_hoat_dong_tu_thien.service.impl;

import com.example.website_quan_li_hoat_dong_tu_thien.entity.Role;
import com.example.website_quan_li_hoat_dong_tu_thien.entity.UserEntity;
import com.example.website_quan_li_hoat_dong_tu_thien.service.UserService;
import com.example.website_quan_li_hoat_dong_tu_thien.dto.RegistrationDto;
import com.example.website_quan_li_hoat_dong_tu_thien.repository.RoleRepository;
import com.example.website_quan_li_hoat_dong_tu_thien.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
