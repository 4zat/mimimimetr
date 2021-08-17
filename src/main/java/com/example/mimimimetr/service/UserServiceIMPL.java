package com.example.mimimimetr.service;

import com.example.mimimimetr.converter.DtoConverter;
import com.example.mimimimetr.domain.User;
import com.example.mimimimetr.dto.UserDto;
import com.example.mimimimetr.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceIMPL implements UserService {

    private final UserRepository userRepository;
    private final DtoConverter dtoConverter;

    public UserServiceIMPL(UserRepository userRepository, DtoConverter dtoConverter) {
        this.userRepository = userRepository;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(dtoConverter::convertUserToDto)
                .collect(Collectors.toList());
    }

    @Override
    public String findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public void updateUsersByChoice(String username) {
        userRepository.updateUsersByChoice(username);
    }

    @Override
    public boolean findUsersByCheckChoice(String username) {
        return userRepository.findUsersByCheckChoice(username);
    }

    @Override
    public <S extends User> S save(S s) {
        return userRepository.save(s);
    }
}
