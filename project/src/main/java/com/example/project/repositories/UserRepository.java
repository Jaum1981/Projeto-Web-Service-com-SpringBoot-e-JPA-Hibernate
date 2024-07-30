package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entities.User;

//nao necessita do @repository pois herda de jpa
public interface UserRepository extends JpaRepository<User, Long> {
    // nao preciso implementar os metodos nesse caso
}
