package com.example.blogapp.controller;

import com.example.blogapp.payload.LoginDto;
import com.example.blogapp.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //Login REST API

    @PostMapping(value = {"/login","/signing"})
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
      String response =  authService.login(loginDto);
      return ResponseEntity.ok(response);
    }
}
