package com.example.social.model;

import com.example.social.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AppUser extends User {


    @Override
    public List<Post> getPosts() {
        this.getPosts();
        return null;
    }

    @Override
    public boolean followOtherUser(AppUser toBeFollowed) {
        this.getFollowing().put(toBeFollowed.getUsername(), toBeFollowed);
        return false;
    }

    @Override
    public List<Post> getFeedPosts() {
        List<Post> followingsPosts = new LinkedList<>();
        this.getFollowing().values().stream()
                .forEach(e -> {
                            List<Post> posts = e.getPosts().stream().filter(p -> {
                                long before24Hours = p.getDate().getTime();
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
