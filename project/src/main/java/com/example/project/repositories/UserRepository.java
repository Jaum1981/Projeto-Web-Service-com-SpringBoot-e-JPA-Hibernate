package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // nao preciso implementar os metodos nesse caso
}
