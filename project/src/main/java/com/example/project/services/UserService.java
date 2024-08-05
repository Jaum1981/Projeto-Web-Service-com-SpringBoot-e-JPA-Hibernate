package com.example.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entities.User;
import com.example.project.repositories.UserRepository;

@Service // registra a classe como componete do spring para poder ser injetada
         // automaticamente
public class UserService {

    @Autowired // injecao de dependencia
    private UserRepository repository;

    // retorna todos os usuarios do DB
    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.get();
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User user) {
        User entity = repository.getReferenceById(id); // prepara o obj monitorado, e so dps vai no BD
        updateData(entity, user);
        return repository.save(entity);
    }

    // metodo aux
    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
