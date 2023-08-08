package com.curdoperations.service.impl;

import com.curdoperations.entity.StudentSignUp;
import com.curdoperations.exception.InvalidCredentialsException;
import com.curdoperations.payload.LoginRequest;
import com.curdoperations.payload.LoginResponse;
import com.curdoperations.repository.StudentSignUpRepository;
import com.curdoperations.service.StudentSignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentSignInServiceImpl implements StudentSignInService {

    @Autowired
    private final StudentSignUpRepository studentSignUpRepository;
    private final StudentSignUpRepository signUpRepository;

    @Override
    public LoginResponse signIn(LoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        Optional<StudentSignUp> byEmail = signUpRepository.findByEmail(email);
        StudentSignUp signUp = byEmail.orElseThrow(
                () -> new InvalidCredentialsException("Invalid Email")
        );

        if(signUp.getPassword().equals(password)){
            return new LoginResponse("WELCOME",true);
        } else{
            throw new InvalidCredentialsException("Inavlid Email and Password");
        }

    }
}
