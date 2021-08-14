package com.example.mimimimetr.converter;

import com.example.mimimimetr.domain.Cat;
import com.example.mimimimetr.domain.User;
import com.example.mimimimetr.dto.CatDto;
import com.example.mimimimetr.dto.UserDto;
import org.springframework.stereotype.Service;


@Service
public class DtoConverter {

    public CatDto convertCatToDto(Cat entity) {
        CatDto dto = new CatDto();
        dto.setCatId(entity.getCatId());
        dto.setCatName(entity.getCatName());
        dto.setCatPoint(entity.getCatPoint());
        dto.setFilename(entity.getFilename());

        return dto;
    }

    public Cat convertDtoToCat(CatDto dto) {
        Cat entity = new Cat();
        entity.setCatId(dto.getCatId());
        entity.setCatName(dto.getCatName());
        entity.setCatPoint(dto.getCatPoint());
        entity.setFilename(dto.getFilename());

        return entity;
    }

    public UserDto convertUserToDto(User entity) {
        UserDto dto = new UserDto();
        dto.setUserId(entity.getUserId());
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        dto.setChoice(entity.isChoice());
        dto.setActive(entity.isActive());

        return dto;
    }

    public User convertDtoToUser(UserDto dto) {
        User entity = new User();
        entity.setUserId(dto.getUserId());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        entity.setChoice(dto.isChoice());
        entity.setActive(dto.isActive());

        return entity;
    }
}
