package com.example.blogapp.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "JwtAuthResponse Model Information"
)
public class JwtAuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";
}
