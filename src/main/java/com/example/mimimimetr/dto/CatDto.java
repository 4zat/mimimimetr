package com.example.mimimimetr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CatDto {

    private int catId;
    private String catName;
    private int catPoint;
    private String filename;
    private boolean bufVoice;
}
