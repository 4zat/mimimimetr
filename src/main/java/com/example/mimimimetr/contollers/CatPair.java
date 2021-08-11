package com.example.mimimimetr.contollers;

import com.example.mimimimetr.dto.CatDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class CatPair {

    private CatDto catDto1;
    private CatDto catDto2;

}
