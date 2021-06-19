package com.example.social.controller;

import com.example.social.dto.PostDto;
import com.example.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/feed/")
public class UserFeedController {

    @Autowired
    private UserService userService;

    @GetMapping("{username}")
    public List<PostDto> getFeed(@PathVariable String username) {
        return userService.getFeedForUser(username);
    }

    @GetMapping("profile/{username}")
    public List<PostDto> getProfileFeed(@PathVariable String username) {
        return userService.getProfileFeed(username);
    }


}
