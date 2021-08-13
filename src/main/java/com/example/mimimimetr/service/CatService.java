package com.example.mimimimetr.service;

import com.example.mimimimetr.dto.CatDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatService {

    public List<CatDto> findAll();

}
