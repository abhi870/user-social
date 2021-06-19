package com.example.social.controller;

import com.example.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connection")
public class UserConnectionsController {

    @Autowired
    private UserService userService;

    @PostMapping("/follow")
    public boolean followOtherUser(@RequestParam String currentUser, @RequestParam String toBeFollowed) {
        userService.followUser(currentUser, toBeFollowed);
        return true;
    }
}
