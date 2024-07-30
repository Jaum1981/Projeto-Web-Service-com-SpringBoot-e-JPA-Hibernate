package com.example.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.entities.User;
import com.example.project.services.UserService;

//CONTROLADOR reST
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    // endpoint
    @GetMapping // para indicar que corresponde a requisisao get do http
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    // endpoint
    @GetMapping(value = "/{id}") // indica que arequisicao vai aceitar um id dentro da url
    public ResponseEntity<User> findById(@PathVariable Long id) { // para considerar como parametro
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
