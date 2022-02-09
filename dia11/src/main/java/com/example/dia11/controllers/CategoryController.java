package com.example.dia11.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.dia11.models.Category;
import com.example.dia11.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/categories/")
@CrossOrigin(origins = "*")
@Api(value = "categories")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findAll")
    @ApiOperation(value = "Find all categories", response = Category.class, responseContainer = "List")
    public ResponseEntity<ArrayList<Category>> findAll(){
        try {
            return ResponseEntity.ok((ArrayList<Category>) categoryService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find a category by its Id", response = Category.class)
    public ResponseEntity<Optional<Category>> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(categoryService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/")
    @ApiOperation(value = "Create a new category on the database", response = Category.class)
    public ResponseEntity<Category> create(@RequestBody Category category){
        try {
            return ResponseEntity.ok(categoryService.create(category));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a category's data", response = Category.class)
    public ResponseEntity<Category> create(@PathVariable Long id, @RequestBody Category category){
        try {
            return ResponseEntity.ok(categoryService.update(id, category));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a category", response = Void.class)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try {
            categoryService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
}
