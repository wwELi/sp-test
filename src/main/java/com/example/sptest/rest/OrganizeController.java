package com.example.sptest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sptest.dto.OrganizeDto;
import com.example.sptest.repository.OrganizeRepository;
import com.example.sptest.service.OrganizeService;

@RestController
@RequestMapping("/organize")
public class OrganizeController {

    @Autowired
    OrganizeService service;

    @Autowired
    OrganizeRepository repository;
    
    @PostMapping()
    public void create() {
        service.create();
    }

    @GetMapping
    public List<OrganizeDto> groups() {
        List<OrganizeDto> list = repository.findAll();
        return list;
    }
}
