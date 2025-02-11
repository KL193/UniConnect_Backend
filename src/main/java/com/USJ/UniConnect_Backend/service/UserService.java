package com.USJ.UniConnect_Backend.service;


import com.USJ.UniConnect_Backend.dao.UserDao;
import com.USJ.UniConnect_Backend.dto.UserDto;
import com.USJ.UniConnect_Backend.entities.UserEntity;
import com.USJ.UniConnect_Backend.exception.UserNotFoundException;
import com.USJ.UniConnect_Backend.util.EntityDtoConversion;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EntityDtoConversion entityDtoConversion;

    public List<UserDto> getAllUsers() {

        List<UserEntity> userList = userDao.findAll();
        return entityDtoConversion.toUserDtoList(userList);
    }

    public UserDto getSelectedUser(String userId) {
        Optional<UserEntity> foundUser = userDao.findById(userId);
        if(!foundUser.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        return entityDtoConversion
                .toUserDto(userDao.getReferenceById(userId));
    }



}
