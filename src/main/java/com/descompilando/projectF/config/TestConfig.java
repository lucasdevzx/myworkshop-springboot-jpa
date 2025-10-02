package com.descompilando.projectF.config;

import com.descompilando.projectF.entities.User;
import com.descompilando.projectF.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Lucas Silva", "lucas@gmail.com", "22997895653", "2049");
        User u2 = new User(null, "Rafael Silva", "rafael@gmail.com", "229987721", "1620");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
