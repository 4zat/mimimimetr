package com.example.mimimimetr.converter;

import com.example.mimimimetr.domain.Cat;
import com.example.mimimimetr.dto.CatDto;
import org.springframework.stereotype.Service;


@Service
public class DtoConverter {

    public CatDto convertCatToDto(Cat entity) {
        CatDto dto = new CatDto();
        dto.setCatId(entity.getCatId());
        dto.setCatName(entity.getCatName());
        dto.setCatPoint(entity.getCatPoint());
        dto.setFilename(entity.getFilename());
        dto.setBufVoice(entity.isBufVoice());

        return dto;
    }

    public Cat convertDtoToCat(CatDto dto) {
        Cat entity = new Cat();
        entity.setCatId(dto.getCatId());
        entity.setCatName(dto.getCatName());
        entity.setCatPoint(dto.getCatPoint());
        entity.setFilename(dto.getFilename());
        entity.setBufVoice(dto.isBufVoice());

        return entity;
    }
}
