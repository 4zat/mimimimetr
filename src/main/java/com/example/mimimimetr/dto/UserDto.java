package com.example.mimimimetr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long userId;

    private String userName;
    private String password;
    private boolean choice;
    private boolean active;
}
