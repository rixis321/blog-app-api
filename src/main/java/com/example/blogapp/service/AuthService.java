package com.example.blogapp.service;

import com.example.blogapp.payload.LoginDto;
import com.example.blogapp.payload.RegisterDto;

public interface AuthService {

    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
