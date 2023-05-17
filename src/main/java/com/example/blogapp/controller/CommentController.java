package com.example.blogapp.controller;

import com.example.blogapp.payload.CommentDto;
import com.example.blogapp.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @Operation(
            summary = "Create Comment REST API",
            description = "Create Comment REST API is used to save comment into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId,
                                                    @Valid @RequestBody CommentDto commentDto){

        return new ResponseEntity<>(commentService.createComment(postId,commentDto), HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get comments by post id REST API",
            description = "Get posts by category id REST API is used to get all comments belonged to particular post from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(name = "postId") long postId){
        return commentService.getCommentsByPostId(postId);

    }
    @Operation(
            summary = "Get comment By Id REST API",
            description = "Get comment By Id REST API is used to get single comment from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") long postId,
                                                     @PathVariable(value = "commentId") long commentId){

       CommentDto commentDto = commentService.getCommentById(postId,commentId);

       return new ResponseEntity<>(commentDto,HttpStatus.OK);
    }

    @Operation(
            summary = "Update Comment REST API",
            description = "Update Comment REST API is used to update a particular comment in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @PutMapping("/posts/{postId}/comments/{commentId}")
    public  ResponseEntity<CommentDto> updateComment(@PathVariable(value = "postId") Long postId,
                                                     @PathVariable(value = "commentId")  Long commentId,
                                                     @Valid @RequestBody CommentDto commentDto){

        return new ResponseEntity<>(commentService.updateComment(postId, commentId, commentDto),HttpStatus.OK);
    }
    @Operation(
            summary = "Delete Comment REST API",
            description = "Delete Comment REST API is used to delete a particular comment from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,
                                                @PathVariable(name = "commentId") Long commentId){
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully",HttpStatus.OK);
    }


}
