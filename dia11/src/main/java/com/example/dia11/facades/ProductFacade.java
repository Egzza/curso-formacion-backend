package com.example.dia11.facades;

import com.example.dia11.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class ProductFacade {
    
    @Autowired
    public ProductFacade(ProductRepository repository){
        super();
    }
}
