package com.USJ.UniConnect_Backend.controller;

import com.USJ.UniConnect_Backend.dto.UserDto;
import com.USJ.UniConnect_Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/usercontroller")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getusers")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }



}
