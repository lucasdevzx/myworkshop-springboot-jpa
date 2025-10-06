package com.descompilando.projectF.config;

import com.descompilando.projectF.entities.*;
import com.descompilando.projectF.entities.enums.OrderStatus;
import com.descompilando.projectF.repositories.*;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        Category cat4 = new Category(null, "Brinquedos Sexuais");
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        Product p6 = new Product(null, "Pinto de Borracha 30cm", "Potencialize o seu prazer com este brinquedinho.", 372.99, "");

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);
        p6.getCategories().add(cat4);
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));

        User u1 = new User(null, "Lucas Silva", "lucas@gmail.com", "22997895653", "2049");
        User u2 = new User(null, "Rafael Silva", "rafael@gmail.com", "229987721", "1620");
        User u3 = new User(null,"Guilherme Stallmann", "zfloss@gmail.com", "4391862877", "zerotwo123");
        User u4 = new User(null,"ISaque Bola", "isaquebola@gmail.com", "2299238312", "frangoline123");
        userRepository.saveAll(Arrays.asList(u1,u2,u3, u4));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);
        Order o4 = new Order(null, Instant.parse("2025-10-04T16:20:22Z"),OrderStatus.PAID, u3);
        Order o5 = new Order(null, Instant.parse("2025-10-04T16:20:22Z"),OrderStatus.WAITING_PAYMENT, u4);
        orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));


    }
}
