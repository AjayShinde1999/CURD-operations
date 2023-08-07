package com.curdoperations.service;

import com.curdoperations.payload.StudentSignUpDto;

import java.util.List;

public interface StudentSignUpService {

    public StudentSignUpDto signUp(StudentSignUpDto signUpDto);

    public StudentSignUpDto getById(long id);

    public List<StudentSignUpDto> getAll();

    public void deleteById(long id);

    public StudentSignUpDto updateSignUpById(StudentSignUpDto signUpDto, long id);
}
