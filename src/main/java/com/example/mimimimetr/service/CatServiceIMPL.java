package com.example.mimimimetr.service;

import com.example.mimimimetr.converter.DtoConverter;
import com.example.mimimimetr.dto.CatDto;
import com.example.mimimimetr.repo.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatServiceIMPL implements CatService {

    private final CatRepository catRepository;
    private final DtoConverter dtoConverter;

    public CatServiceIMPL(CatRepository catRepository, DtoConverter dtoConverter) {
        this.catRepository = catRepository;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public List<CatDto> findAll() {
        return catRepository.findAll().stream()
                .map(dtoConverter::convertCatToDto)
                .collect(Collectors.toList());
    }

}
