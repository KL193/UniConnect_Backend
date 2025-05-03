package com.USJ.UniConnect_Backend.entities;


import com.USJ.UniConnect_Backend.dto.UserDto;
import com.USJ.UniConnect_Backend.dto.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;




import java.util.Date;



@Data

@NoArgsConstructor
@AllArgsConstructor
//@Table(name="users")
@Document(collection = "users")

public class UserEntity {

    @Id
    private String id;
    private String name;

    @Indexed(unique = true)
    private String email;

    private String address;
    private String password;


    private UserRole role;

    public UserDto toDto() {
        return new UserDto(this.id, this.name, this.email, this.address, this.password, this.role);
    }
}
