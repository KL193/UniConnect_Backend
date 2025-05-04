package com.USJ.UniConnect_Backend.dto;

import com.USJ.UniConnect_Backend.entities.ProfileEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

    private long id;
    private String email;
    private String jobTitle;
    private String company;
    private String location;
    private String about;
    private String picture;
    private List<String> skills;
    private List<Experience> experience;
    private List<Certification> certifications;

    public ProfileEntity toEntity() {
        return new ProfileEntity(this.id,this.email,this.jobTitle,this.company,this.location,this.about,this.picture!=null? Base64.getDecoder().decode(this.picture):null,this.skills,this.experience,this.certifications);
    }
}
