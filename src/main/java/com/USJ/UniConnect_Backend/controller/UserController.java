package com.USJ.UniConnect_Backend.controller;

import com.USJ.UniConnect_Backend.dto.UserDto;

import com.USJ.UniConnect_Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/usercontroller")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService  = userService ;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        if(userService.emailExists(userDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }

        userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }







}



