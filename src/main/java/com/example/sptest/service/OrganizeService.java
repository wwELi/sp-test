package com.example.sptest.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sptest.dto.OrganizeDto;
import com.example.sptest.repository.OrganizeRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
public class OrganizeService {

    @Data
    @AllArgsConstructor
    class Group {
        private String name;
    }

    @Autowired
    OrganizeRepository organizeRepository;

    public void create(Group group) {
        String groupName = Optional.ofNullable(group).orElse(new Group("GROUP2")).getName();
        OrganizeDto dto = OrganizeDto.builder().createTime(new Date()).groupName(groupName).build();
        organizeRepository.save(dto);
    }
}
