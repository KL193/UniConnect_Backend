package com.USJ.UniConnect_Backend.controller;

import com.USJ.UniConnect_Backend.dto.UserDto;
import com.USJ.UniConnect_Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/usercontroller")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService  = userService ;
    }

    @GetMapping("/getusers")
    public ResponseEntity<List<UserDto>>  getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


}



