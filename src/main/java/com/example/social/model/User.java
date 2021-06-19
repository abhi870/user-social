package com.example.social.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class User {

    private String username;
    private String password;
    private List<Post> posts;
    private Map<String,User> following;

    public abstract List<Post> getPosts();
    public abstract boolean followOtherUser(AppUser toBeFollowed);
    public abstract List<Post> getFeedPosts();
}
