package com.USJ.UniConnect_Backend.dao;

import com.USJ.UniConnect_Backend.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {


    boolean existsByEmail(String email);
    UserEntity findByEmail(String email);

}
