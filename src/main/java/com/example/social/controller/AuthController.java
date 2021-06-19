package com.example.social.controller;

import com.example.social.exceptions.UsernameAlreadyPresentException;
import com.example.social.service.AuthService;
import com.example.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public boolean register(@RequestParam String username, @RequestParam String password) throws UsernameAlreadyPresentException {
        return authService.register(username, password);
    }
}
