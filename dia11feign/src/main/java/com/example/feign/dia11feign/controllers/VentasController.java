package com.example.feign.dia11feign.controllers;

import java.util.ArrayList;

import com.example.feign.dia11feign.models.Product;
import com.example.feign.dia11feign.utils.VentasUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentasController {
    
    @Autowired
    private VentasUtils ventasUtils;

    @GetMapping("/findProducts")
    public ResponseEntity<ArrayList<Product>> findAllProducts(){
        try {
            return ResponseEntity.ok(ventasUtils.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
