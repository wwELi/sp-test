package com.example.sptest.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.sptest.dto.OrganizeUserDto;
import com.example.sptest.dto.UserDto;
import com.example.sptest.dto.UserOrganizeMapPrimaryKey;
import com.example.sptest.repository.OrganizeUserRepository;
import com.example.sptest.repository.UserRepository;

@Service
public class UserService {

    @Value("address-prefix")
    String addressPrefix;
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    OrganizeUserRepository organizeUserRepository;

    @Transactional
    public UserDto create(UserDto user) {
        UserDto userDto = UserDto.builder()
            .name(user.getName())
            .age(user.getAge() + 1)
            .address(addressPrefix + user.getAddress())
            .createTime(new Date())
            .build();
        
        UserDto entity = userRepository.save(userDto);
        OrganizeUserDto organizeUserDto = OrganizeUserDto.builder()
            .pk(new UserOrganizeMapPrimaryKey(1, null))
            .build();

        organizeUserRepository.save(organizeUserDto);
        return entity;
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream()
            .filter(u -> u.getName() != null)
            .toList();
    }

    public UserDto getUserById(Integer id) {
        UserDto ou = userRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "not find user"));

        return ou;
    }
}
