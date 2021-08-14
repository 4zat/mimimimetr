package com.example.mimimimetr.service;

import com.example.mimimimetr.domain.User;
import com.example.mimimimetr.dto.UserDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserService {

    public List<UserDto> findAll();

    User findByUserName(String username);

    void findUsersByChoice(String username);

    boolean findUsersByCheckChoice(String username);
}
