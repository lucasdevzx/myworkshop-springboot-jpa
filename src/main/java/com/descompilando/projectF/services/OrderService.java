package com.descompilando.projectF.services;

import com.descompilando.projectF.entities.Order;
import com.descompilando.projectF.entities.User;
import com.descompilando.projectF.repositories.OrderRepository;
import com.descompilando.projectF.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Declara a classe para o conteiner do framework
public class OrderService {

    @Autowired // Injeta a dependência do conteiner automaticamente
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}
