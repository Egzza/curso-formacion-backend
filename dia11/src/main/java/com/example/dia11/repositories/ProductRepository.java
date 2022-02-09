package com.example.dia11.repositories;

import org.springframework.stereotype.Repository;

import com.example.dia11.models.Product;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
