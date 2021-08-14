package com.example.mimimimetr.service;

import com.example.mimimimetr.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {

    public List<UserDto> findAll();
}
