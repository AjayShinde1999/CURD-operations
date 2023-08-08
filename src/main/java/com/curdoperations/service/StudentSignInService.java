package com.curdoperations.service;

import com.curdoperations.payload.LoginRequest;
import com.curdoperations.payload.LoginResponse;

public interface StudentSignInService {

    public LoginResponse signIn(LoginRequest request);
}
