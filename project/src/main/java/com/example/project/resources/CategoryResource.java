package com.example.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.entities.Category;
import com.example.project.services.CategoryService;

//CONTROLADOR rest
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    // endpoint
    @GetMapping // para indicar que corresponde a requisicao get do http
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    // endpoint
    @GetMapping(value = "/{id}") // indica que arequisicao vai aceitar um id dentro da url
    public ResponseEntity<Category> findById(@PathVariable Long id) { // para considerar como parametro
        Category category = service.findById(id);
        return ResponseEntity.ok().body(category);
    }
}
