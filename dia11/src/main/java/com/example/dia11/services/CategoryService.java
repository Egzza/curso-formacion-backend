package com.example.dia11.services;

import java.util.List;
import java.util.Optional;

import com.example.dia11.models.Category;
import com.example.dia11.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return (List<Category>) categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }

    public Category create(Category Category){
        return categoryRepository.save(Category);
    }

    public Category update(Long id, Category Category){
        Category p = categoryRepository.findById(id).get();
        
        if(p.getId() != null){
            p.setName(Category.getName());
        }
        
        return categoryRepository.save(p);
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }
}
