package com.USJ.UniConnect_Backend.entities;


import com.USJ.UniConnect_Backend.dto.UserDto;
import com.USJ.UniConnect_Backend.dto.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;



@Data
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

    public UserDto toDto() {
        return new UserDto(this.id, this.name, this.email, this.address, this.password, this.role);
    }
}
