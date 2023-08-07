package com.curdoperations.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "STUDENT_SIGN_UP")
public class StudentSignUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name",nullable = false)
    private String name;

    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Column(name = "mobile",nullable = false,unique = true)
    private String mobile;

    @Column(name = "password")
    private String password;

}
