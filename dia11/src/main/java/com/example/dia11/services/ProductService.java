package com.example.dia11.services;

import java.util.List;
import java.util.Optional;

import com.example.dia11.models.Product;
import com.example.dia11.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    public Product update(Long id, Product product){
        Product p = productRepository.findById(id).get();
        
        if(p.getId() != null){
            p.setName(product.getName());
        }
        
        return productRepository.save(p);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

}
