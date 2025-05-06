package com.USJ.UniConnect_Backend.controller;

import com.USJ.UniConnect_Backend.dto.LoginDto;
import com.USJ.UniConnect_Backend.dto.ResponseDto;
import com.USJ.UniConnect_Backend.dto.UserDto;

import com.USJ.UniConnect_Backend.exception.JobPortalException;
import com.USJ.UniConnect_Backend.service.UserService;
import com.USJ.UniConnect_Backend.util.Utilities;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Validated
@RequestMapping("api/v1/usercontroller")
public class UserController {


    @Autowired
    private UserService userService;

  /*  @Autowired
    public UserController(UserService userService) {

        this.userService  = userService ;
    }*/


    @PostMapping("/signup")
    public ResponseEntity<UserDto> registerUser(@RequestBody @Valid UserDto userDto)throws JobPortalException{

        userDto.setId(Utilities.getNextSequence("users"));

        userDto = userService.registerUser(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody @Valid LoginDto  loginDto)throws JobPortalException {


        return new ResponseEntity<>(userService.loginUser(loginDto), HttpStatus.OK);

    }

   /* @PostMapping("/changePassword")
    public ResponseEntity<ResponseDto> changePassword(@RequestBody @Valid LoginDto  loginDto)throws JobPortalException{
        return new ResponseEntity<>(userService.changePassword(loginDto),HttpStatus.OK);
    }*/





}



