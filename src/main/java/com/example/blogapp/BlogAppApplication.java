package com.example.blogapp;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Blog App REST API",
                description = "Spring Boot Blog REST API documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "rixis321",
                        url = "https://github.com/rixis321"
                ),
                license = @License(
                        name = "Apache 2.0"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot Blog App documentation",
                url = "https://github.com/rixis321/blog-app-api"
        )
)
public class BlogAppApplication {
@Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(BlogAppApplication.class, args);
    }

}
