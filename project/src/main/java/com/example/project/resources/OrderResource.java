package com.example.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.entities.Order;
import com.example.project.services.OrderService;

//CONTROLADOR rest
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    // endpoint
    @GetMapping // para indicar que corresponde a requisicao get do http
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    // endpoint
    @GetMapping(value = "/{id}") // indica que arequisicao vai aceitar um id dentro da url
    public ResponseEntity<Order> findById(@PathVariable Long id) { // para considerar como parametro
        Order order = service.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
