package com.USJ.UniConnect_Backend.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private String phoneNumber;
    private String profilePictureUrl;
    private Date createdAt;
    private Date updatedAt;
    private boolean status;
}
