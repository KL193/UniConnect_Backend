package com.USJ.UniConnect_Backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private String phoneNumber;
    private String profilePictureUrl;
    private Date createdAt;
    private Date updatedAt;
    private boolean status;
}
