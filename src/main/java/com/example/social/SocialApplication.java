package com.example.social;

import com.example.social.exceptions.UsernameAlreadyPresentException;
import com.example.social.model.AppUser;
import com.example.social.model.User;
import com.example.social.model.UserAuthentication;
import com.example.social.repository.UserAuthenticationRepository;
import com.example.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.LinkedList;

@SpringBootApplication
public class SocialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialApplication.class, args);
    }

    @Autowired
    private UserAuthenticationRepository authentication;
    @Autowired
    private UserRepository userRepository;


//    @Bean
//    public CommandLineRunner demo() throws UsernameAlreadyPresentException {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                authentication.register("abhi870", "abhi870");
//                authentication.register("prashant", "passkey");
//                authentication.register("user3", "user3");
//            }
//        };
//
//    }

}

