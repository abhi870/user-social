package com.example.social.controller;

import com.example.social.dto.PostDto;
import com.example.social.exceptions.UsernameAlreadyPresentException;
import com.example.social.service.AuthService;
import com.example.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ConnectionsController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @GetMapping("/feed/{username}")
    public List<PostDto> getFeed(@PathVariable String username) {
        return userService.getFeedForUser(username);
    }

    @GetMapping("/profile/{username}")
    public List<PostDto> getProfileFeed(@PathVariable String username) {
        return userService.getProfileFeed(username);
    }

    @PostMapping("/follow")
    public boolean followOtherUser(@RequestParam String currentUser, @RequestParam String toBeFollowed) {
        userService.followUser(currentUser, toBeFollowed);
        return true;
    }

    @PostMapping("/register")
    public boolean register(@RequestParam String username, @RequestParam String password) throws UsernameAlreadyPresentException {
        return authService.register(username, password);
    }
}
