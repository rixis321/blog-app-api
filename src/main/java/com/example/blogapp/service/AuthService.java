package com.example.blogapp.service;

import com.example.blogapp.payload.LoginDto;

public interface AuthService {

    String login(LoginDto loginDto);
}
