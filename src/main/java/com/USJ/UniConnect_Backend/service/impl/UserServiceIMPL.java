package com.USJ.UniConnect_Backend.service.impl;

import com.USJ.UniConnect_Backend.dao.UserDao;
import com.USJ.UniConnect_Backend.dto.LoginDto;
import com.USJ.UniConnect_Backend.dto.UserDto;
import com.USJ.UniConnect_Backend.entities.UserEntity;
import com.USJ.UniConnect_Backend.exception.JobPortalException;
//import com.USJ.UniConnect_Backend.service.ProfileService;
import com.USJ.UniConnect_Backend.service.ProfileService;
import com.USJ.UniConnect_Backend.service.UserService;


import com.USJ.UniConnect_Backend.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service(value="userService")
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileService profileService;

    @Override
    public UserDto registerUser(UserDto userDto) throws JobPortalException {
        Optional<UserEntity> optional = userDao.findByEmail(userDto.getEmail());

        if (optional.isPresent())throw new JobPortalException("User_Found");
        userDto.setProfileId(profileService.createProfile(userDto.getEmail()));
        userDto.setId(Utilities.getNextSequence("users"));
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserEntity userEntity = userDto.toEntity();
        userEntity = userDao.save(userEntity);
        return userEntity.toDto();
    }

    @Override
    public UserDto loginUser(LoginDto  loginDto) throws JobPortalException {

        UserEntity userEntity = userDao.findByEmail(loginDto.getEmail()).orElseThrow(()->new JobPortalException("User_Not_Found"));
        if(!passwordEncoder.matches(loginDto.getPassword(), userEntity.getPassword()))throw new JobPortalException("Wrong_password");

        return userEntity.toDto();
    }


}
