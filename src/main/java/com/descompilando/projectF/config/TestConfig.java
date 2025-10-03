package com.descompilando.projectF.config;

import com.descompilando.projectF.entities.User;
import com.descompilando.projectF.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration // Sinaliza que a classe atual é uma classe de ocnfigurações
@Profile("test") // Seleciona o perfil de testes para a classe
public class TestConfig implements CommandLineRunner { // Implementa a interface de rastreio de métodos do framework em momento de execução

    @Autowired // Injeção de dependência
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Lucas Silva", "lucas@gmail.com", "22997895653", "2049");
        User u2 = new User(null, "Rafael Silva", "rafael@gmail.com", "229987721", "1620");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
