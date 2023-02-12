package com.example.forum_web_ver_2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto implements Serializable {
    private String FirstName;
    private String LastName;
    private String DateofBirth;
    private String ImgUrl;
    private String Gender;
    private String Adress;
}
