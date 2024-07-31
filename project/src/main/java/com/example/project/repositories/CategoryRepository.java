package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entities.Category;

//nao necessita do @repository pois herda de jpa
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // nao preciso implementar os metodos nesse caso
}
