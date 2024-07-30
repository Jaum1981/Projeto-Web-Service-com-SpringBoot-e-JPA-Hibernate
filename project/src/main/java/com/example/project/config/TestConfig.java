package com.example.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.project.entities.User;
import com.example.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {// dataBase seeding

    // primeiro caso de dependecy injection:
    @Autowired
    private UserRepository userRepository; // o proprio spring resolve essa dependencia e associa

    // executar quando for iniciado: implementa o comandline runner
    // tudo dentro dele sera executado quando a aplicacao for iniciada
    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "joao", "joao@email.com", "12345678", "123");
        User user2 = new User(null, "maria", "maria@email.com", "87654321", "321");

        // salvar no banco de dados:
        userRepository.saveAll(Arrays.asList(user1, user2)); // salva em uma lista

    }

}
