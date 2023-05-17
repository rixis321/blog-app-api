package com.example.blogapp.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "LoginDto Model Information"
)
public class LoginDto {

    private String usernameOrEmail;
    private String password;
}
