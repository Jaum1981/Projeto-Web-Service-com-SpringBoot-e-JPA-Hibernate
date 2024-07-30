package com.example.project.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping // para indicar que corresponde a requisisao get do htpp
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "jaum", "jaum@email.com", "4002-8922", "12345");
        return ResponseEntity.ok().body(u);
    }
}
