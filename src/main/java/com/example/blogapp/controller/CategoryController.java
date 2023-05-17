package com.example.blogapp.controller;

import com.example.blogapp.payload.CategoryDto;
import com.example.blogapp.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @Operation(
            summary = "Create Category REST API",
            description = "Create Category REST API is used to save category into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
      return new ResponseEntity<>(categoryService.addCategory(categoryDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Category By Id REST API",
            description = "Get Category By Id REST API is used to get single category from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable(name = "id") Long categoryId){
        return new ResponseEntity<>(categoryService.getCategory(categoryId),HttpStatus.OK);
    }
    @Operation(
            summary = "Get All comments REST API",
            description = "Get All comments REST API is used to fetch all comments from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping()
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return new ResponseEntity<List<CategoryDto>>(categoryService.getAllCategories(),HttpStatus.OK);
    }
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @Operation(
            summary = "Update Category REST API",
            description = "Update Category REST API is used to update a particular category in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable(name = "id") Long categoryId){
        return new ResponseEntity<>(categoryService.updateCategory(categoryDto, categoryId),HttpStatus.OK);
    }

    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @Operation(
            summary = "Delete Category REST API",
            description = "Delete Category REST API is used to delete a particular category from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }
}
