package com.example.sptest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sptest.dto.OrganizeUserDto;

public interface OrganizeUserRepository extends JpaRepository<OrganizeUserDto, Integer> {
    
}
