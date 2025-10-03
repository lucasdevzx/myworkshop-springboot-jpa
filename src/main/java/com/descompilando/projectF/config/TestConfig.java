package com.descompilando.projectF.config;

import com.descompilando.projectF.entities.Order;
import com.descompilando.projectF.entities.User;
import com.descompilando.projectF.repositories.OrderRepository;
import com.descompilando.projectF.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration // Sinaliza que a classe atual é uma classe de ocnfigurações
@Profile("test") // Seleciona o perfil de testes para a classe
public class TestConfig implements CommandLineRunner { // Implementa a interface de rastreio de métodos do framework em momento de execução

    @Autowired // Injeção de dependência
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Lucas Silva", "lucas@gmail.com", "22997895653", "2049");
        User u2 = new User(null, "Rafael Silva", "rafael@gmail.com", "229987721", "1620");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
