package com.example.social.model;

import com.example.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AppUser extends User {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Post> getAllPosts() {
        return this.getPosts();
    }

    @Override
    public boolean followOtherUser(AppUser toBeFollowed) {
        this.getFollowing().put(toBeFollowed.getUsername(), toBeFollowed);
        return true;
    }

    @Override
    public List<Post> getFeedPosts() {
        List<Post> followingsPosts = new LinkedList<>();
        this.getFollowing().values().stream()
                .forEach(e -> {
                            List<Post> posts = e.getPosts().stream().filter(p -> {
                                long before24Hours = Instant.now().minus(1, ChronoUnit.DAYS).getEpochSecond();
                                if (p.getDate().getTime() > before24Hours)
                                    return true;
                                else
                                    return false;
                            }).collect(Collectors.toList());
                            followingsPosts.addAll(posts);
                        }
                );
        return followingsPosts;
    }
}
