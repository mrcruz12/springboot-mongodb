package com.mrcruztech.mongodb.config;

import com.mrcruztech.mongodb.domain.User;
import com.mrcruztech.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;

    @Override
    public void run(String... args) throws Exception {

        userRepo.deleteAll();

        User ananda = new User(null, "Ananda N A da Cruz", "ananda@gmail.com");
        User marco = new User(null, "Marco A R da Cruz", "marco@gmail.com");
        User wilian = new User(null, "Wilian R da Cruz", "wilian@gmail.com");
        User lucas = new User(null, "Lucas R da Cruz", "lucas@gmail.com");

        userRepo.saveAll(Arrays.asList(ananda, marco, wilian, lucas));
    }
}

