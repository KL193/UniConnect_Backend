package com.USJ.UniConnect_Backend.service;

import com.USJ.UniConnect_Backend.dto.UserDto;

public interface UserService {

    void saveUser(UserDto userDto);
    boolean emailExists(String email);
}
