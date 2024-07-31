package com.example.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.project.entities.Category;
import com.example.project.entities.Order;
import com.example.project.entities.User;
import com.example.project.entities.enums.OrderStatus;
import com.example.project.repositories.CategoryRepository;
import com.example.project.repositories.OrderRepository;
import com.example.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {// dataBase seeding

    // primeiro caso de dependecy injection:
    @Autowired
    private UserRepository userRepository; // o proprio spring resolve essa dependencia e associa

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // executar quando for iniciado: implementa o commandline runner
    // tudo dentro dele sera executado quando a aplicacao for iniciada
    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        User user1 = new User(null, "joao", "joao@email.com", "12345678", "123");
        User user2 = new User(null, "maria", "maria@email.com", "87654321", "321");

        // formato ISO8601
        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAINTING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, user1);

        // salvar no banco de dados:
        userRepository.saveAll(Arrays.asList(user1, user2)); // salva em uma lista
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

    }

}
