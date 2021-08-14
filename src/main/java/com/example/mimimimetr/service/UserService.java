package com.example.mimimimetr.service;

import com.example.mimimimetr.domain.User;
import com.example.mimimimetr.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    String findByUserName(String username);

    void findUsersByChoice(String username);

    boolean findUsersByCheckChoice(String username);

    <S extends User> S save(S s);

}
