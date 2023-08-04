package com.example.sptest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sptest.dto.OrganizeDto;

public interface OrganizeRepository extends JpaRepository<OrganizeDto, Integer>{
    
}
