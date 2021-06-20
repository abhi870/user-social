package com.example.social;

import com.example.social.exceptions.UsernameAlreadyPresentException;
import com.example.social.model.*;
import com.example.social.repository.UserAuthenticationRepository;
import com.example.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class SocialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialApplication.class, args);
    }

    @Autowired
    private UserAuthenticationRepository authentication;
    @Autowired
    private UserRepository userRepository;


    @Bean
    public CommandLineRunner demo() throws UsernameAlreadyPresentException {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                authentication.register("abhi870", "abhi870");
                authentication.register("prashant", "passkey");
                authentication.register("user3", "user3");
                authentication.register("mandar", "usr4");

                userRepository.getByid("abhi870").getFollowing().put("prashant",userRepository.getByid("prashant"));

                List<Comment> commentList = new LinkedList<>();
                Comment comm1 = new Comment("1","prashant","1","some comment", new Date());
                commentList.add(comm1);
                Post post1 = new Post("1","abhi870","imgurl1","caption1",commentList,new Date());

                List<Comment> commentList2 = new LinkedList<>();
                Comment comm2 = new Comment("1","prashant","1","some comment", new Date());
                commentList2.add(comm1);
                Post post2 = new Post("1","mandar","imgurl1","caption1",commentList,new Date());
                userRepository.getByid("mandar").getPosts().add(post2);
                userRepository.getByid("abhi870").getPosts().add(post1);

            }
        };

    }
}

