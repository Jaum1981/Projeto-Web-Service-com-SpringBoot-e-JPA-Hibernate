package com.example.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entities.Category;
import com.example.project.repositories.CategoryRepository;

@Service // registra a classe como componete do spring para poder ser injetada
         // automaticamente
public class CategoryService {

    @Autowired // injecao de dependencia
    private CategoryRepository repository;

    // retorna todos os Categorys do DB
    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = repository.findById(id);
        return category.get();
    }
}
