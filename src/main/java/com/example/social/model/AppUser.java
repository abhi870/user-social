package com.example.social.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AppUser extends User {


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
