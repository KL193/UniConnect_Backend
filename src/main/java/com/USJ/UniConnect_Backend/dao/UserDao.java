package com.USJ.UniConnect_Backend.dao;

import com.USJ.UniConnect_Backend.entities.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {

    public Optional<UserEntity> findByEmail(String email);

   /* boolean existsByEmail(String email);
    UserEntity findByEmail(String email);*/

}
