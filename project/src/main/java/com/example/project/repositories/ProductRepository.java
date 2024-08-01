package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
