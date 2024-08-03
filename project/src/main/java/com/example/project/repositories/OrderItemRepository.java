package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entities.OrderItem;
import com.example.project.entities.pk.OrderItemPK;

//nao necessita do @repository pois herda de jpa
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
    // nao preciso implementar os metodos nesse caso
}
