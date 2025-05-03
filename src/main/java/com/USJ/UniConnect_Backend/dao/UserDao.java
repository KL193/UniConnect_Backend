package com.USJ.UniConnect_Backend.dao;

import com.USJ.UniConnect_Backend.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends MongoRepository<UserEntity,String> {

    public Optional<UserEntity> findByEmail(String email);



}
