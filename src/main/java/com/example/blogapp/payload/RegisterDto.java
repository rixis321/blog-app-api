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
        description = "RegisterDto Model Information"
)
public class RegisterDto {
    private String name;
    private String username;
    private String email;
    private String password;
}
