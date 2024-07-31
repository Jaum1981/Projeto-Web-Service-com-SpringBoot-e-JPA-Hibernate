package com.example.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entities.Order;
import com.example.project.repositories.OrderRepository;

@Service // registra a classe como componete do spring para poder ser injetada
         // automaticamente
public class OrderService {

    @Autowired // injecao de dependencia
    private OrderRepository repository;

    // retorna todos os orders do DB
    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = repository.findById(id);
        return order.get();
    }
}
