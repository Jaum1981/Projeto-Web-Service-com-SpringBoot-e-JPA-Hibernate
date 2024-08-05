package com.example.project.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.project.entities.User;
import com.example.project.services.UserService;

//CONTROLADOR rest
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    // endpoint
    @GetMapping // para indicar que corresponde a requisicao get do http
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

    @PostMapping // recebe o metodo post do http
    public ResponseEntity<User> insert(@RequestBody User user) { // anotation para desserializar json para obj User
        service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}") // mesmo esquema mas para delete
    public ResponseEntity<Void> delete(@PathVariable Long id) { // void pois a resposta da requisicao nao retorna nenhum
                                                                // corpo // path variable para reconhecer como variavel
                                                                // da url
        service.delete(id);
        return ResponseEntity.noContent().build(); // retorna uma resposta vazia (codigo 204)
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        user = service.update(id, user);
        return ResponseEntity.ok().body(user);
    }
}
