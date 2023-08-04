package com.example.sptest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sptest.dto.UserDto;

public interface UserRepository extends JpaRepository<UserDto, Integer> {
    
}
