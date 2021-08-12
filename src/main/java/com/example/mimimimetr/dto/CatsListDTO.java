package com.example.mimimimetr.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CatsListDTO  implements Serializable {

    List<CatDto> cats;

}
