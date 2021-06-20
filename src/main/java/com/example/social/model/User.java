package com.example.social.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class User {

    private String username;
    private String password;
    private List<Post> posts;
    private Map<String,User> following;


    public abstract List<Post> getAllPosts();
    public abstract boolean followOtherUser(AppUser toBeFollowed);
    public abstract List<Post> getFeedPosts();
}
