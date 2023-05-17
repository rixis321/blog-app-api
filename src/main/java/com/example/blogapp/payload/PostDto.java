package com.example.blogapp.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Schema(
        description = "PostDto Model Information"
)
public class PostDto {
    private long id;
    @Schema(
            description = "Blog Post Title"
    )
    @NotEmpty(message = "Title should not be null or empty")
    @Size(min = 2,message = "Post title should have at least 2 characters")
    private String title;
    @Schema(
            description = "Blog Post Description"
    )
    @NotEmpty
    @Size(min = 10, message = "Description should have at least 10 characters")
    private String description;
    @Schema(
            description = "Blog Post Content"
    )
    @NotEmpty(message = "Content should not be null or empty")
    private String content;

    @Schema(
            description = "Comments belonging to Blog Post"
    )
    private Set<CommentDto> comments;

    @Schema(
            description = "Blog Post Category"
    )
    private Long categoryId;

}
