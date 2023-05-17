package com.example.blogapp.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private long id;
    @NotEmpty(message = "Title should not be null or empty")
    @Size(min = 2,message = "Post title should have at least 2 characters")
    private String title;
    @NotEmpty
    @Size(min = 10, message = "Description should have at least 10 characters")
    private String description;
    @NotEmpty(message = "Content should not be null or empty")
    private String content;

    private Set<CommentDto> comments;
    private Long categoryId;

}
