package com.USJ.UniConnect_Backend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class UserEntity {

    @Id
    private String id;
    private String name;

    @Column(unique = true)
    private String email;

    private String address;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
