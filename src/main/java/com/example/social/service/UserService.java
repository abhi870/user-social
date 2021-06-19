package com.example.social.service;

import com.example.social.dto.PostDto;

import java.util.List;

public interface UserService {

    List<PostDto> getFeedForUser(String username);

    boolean followUser(String currentUser, String toBeFollowed);

    List<PostDto> getProfileFeed(String username);

}
