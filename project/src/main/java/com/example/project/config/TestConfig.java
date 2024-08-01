package com.example.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.project.entities.Category;
import com.example.project.entities.Order;
import com.example.project.entities.Product;
import com.example.project.entities.User;
import com.example.project.entities.enums.OrderStatus;
import com.example.project.repositories.CategoryRepository;
import com.example.project.repositories.OrderRepository;
import com.example.project.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

    // executar quando for iniciado: implementa o commandline runner
    // tudo dentro dele sera executado quando a aplicacao for iniciada
    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // salvando em paradigma orientada a objetos
        p1.getCategory().add(category2);
        p2.getCategory().add(category1);
        p3.getCategory().add(category1);
        p3.getCategory().add(category3);
        p4.getCategory().add(category1);
        p4.getCategory().add(category3);
        p5.getCategory().add(category2);

        // relacional:
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User user1 = new User(null, "joao", "joao@email.com", "12345678", "123");
        User user2 = new User(null, "maria", "maria@email.com", "87654321", "321");

        // formato ISO8601
        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAINTING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, user1);

        // salvar no banco de dados:
        userRepository.saveAll(Arrays.asList(user1, user2)); // salva em uma lista
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

    }

}
