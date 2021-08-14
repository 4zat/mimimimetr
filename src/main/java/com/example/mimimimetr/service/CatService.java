package com.example.mimimimetr.service;

import com.example.mimimimetr.dto.CatDto;

import java.util.List;

public interface CatService {

    List<CatDto> findAll();

    void pointCounter(int id, int point);
}
