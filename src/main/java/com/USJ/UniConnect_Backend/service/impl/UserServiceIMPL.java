package com.USJ.UniConnect_Backend.service.impl;

import com.USJ.UniConnect_Backend.dao.UserDao;
import com.USJ.UniConnect_Backend.dto.UserDto;
import com.USJ.UniConnect_Backend.entities.UserEntity;
import com.USJ.UniConnect_Backend.service.UserService;
import com.USJ.UniConnect_Backend.util.EntityDtoConversion;
import com.USJ.UniConnect_Backend.util.UtilityData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private EntityDtoConversion entityDtoConversion;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {
        userDto.setId(UtilityData.generateuserId());
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        UserEntity userEntity = entityDtoConversion.toUserEntity(userDto);
        userDao.save(userEntity);
    }

    @Override
    public boolean emailExists(String email) {
        return userDao.existsByEmail(email);
    }
}
