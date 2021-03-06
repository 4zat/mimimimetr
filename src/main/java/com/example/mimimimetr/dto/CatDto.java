package com.example.mimimimetr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CatDto implements Serializable {

    private int catId;
    private String catName;
    private int catPoint;
    private String filename;
}
