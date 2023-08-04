package com.example.sptest.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sptest.dto.OrganizeDto;
import com.example.sptest.repository.OrganizeRepository;

@Service
public class OrganizeService {
    @Autowired
    OrganizeRepository organizeRepository;

    public void create() {
        OrganizeDto dto = OrganizeDto.builder().createTime(new Date()).groupName("group1").build();
        organizeRepository.save(dto);
    }
}
