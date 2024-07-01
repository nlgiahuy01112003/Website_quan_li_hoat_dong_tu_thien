package com.example.community.repos;


import com.example.community.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String userName);
    UserEntity findFirstByUsername(String username);
}
