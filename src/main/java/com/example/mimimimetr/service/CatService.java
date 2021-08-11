package com.example.mimimimetr.service;

import com.example.mimimimetr.dto.CatDto;

import java.util.List;

public interface CatService {

    public List<CatDto> findAll();

    public CatDto findById(Long id);
}
