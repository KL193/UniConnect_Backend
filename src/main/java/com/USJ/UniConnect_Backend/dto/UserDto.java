package com.USJ.UniConnect_Backend.dto;


import com.USJ.UniConnect_Backend.entities.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String Id;
    private String name;
    private String email;
    private String address;
    private String password;


    private UserRole role;
}
