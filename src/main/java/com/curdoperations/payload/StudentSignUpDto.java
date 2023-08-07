package com.curdoperations.payload;

import lombok.Data;

@Data
public class StudentSignUpDto {

    private Long id;
    private String name;
    private String email;
    private String mobile;
    private String password;

}
