package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entities.Order;

//nao necessita do @repository pois herda de jpa
public interface OrderRepository extends JpaRepository<Order, Long> {
    // nao preciso implementar os metodos nesse caso
}
