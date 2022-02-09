package com.example.feign.dia11feign.utils;

import java.util.ArrayList;

import com.example.feign.dia11feign.models.Product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "venta", url = "http://localhost:8080/api/products")
public interface VentasUtils {
    
    @GetMapping("/findAll")
    public ArrayList<Product> findAll();
}
