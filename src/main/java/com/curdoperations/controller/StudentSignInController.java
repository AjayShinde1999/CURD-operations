package com.curdoperations.controller;

import com.curdoperations.payload.LoginRequest;
import com.curdoperations.payload.LoginResponse;
import com.curdoperations.service.StudentSignInService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class StudentSignInController {

    private final StudentSignInService studentSignInService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> signIn(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = studentSignInService.signIn(loginRequest);
        return new ResponseEntity<>(loginResponse, HttpStatus.ACCEPTED);
    }
}
