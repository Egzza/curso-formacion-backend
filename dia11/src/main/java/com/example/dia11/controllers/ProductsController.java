package com.example.dia11.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.dia11.models.Product;
import com.example.dia11.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
@Api(value = "products")
public class ProductsController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    @ApiOperation(value = "Find all products", response = Product.class, responseContainer = "List")
    public ResponseEntity<ArrayList<Product>> findAll(){
        try {
            return ResponseEntity.ok((ArrayList<Product>) productService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find a product by its Id", response = Product.class)
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(productService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/")
    @ApiOperation(value = "Create a new product in the database", response = Product.class)
    public ResponseEntity<Product> create(@RequestBody Product product){
        try {
            return ResponseEntity.ok(productService.create(product));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a porduct's data", response = Product.class)
    public ResponseEntity<Product> create(@PathVariable Long id, @RequestBody Product product){
        try {
            return ResponseEntity.ok(productService.update(id, product));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a product", response = Void.class)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try {
            productService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
