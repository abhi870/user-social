package com.example.social.service;

import com.example.social.exceptions.UserDoesNotExistsException;
import com.example.social.exceptions.UsernameAlreadyPresentException;

public interface AuthService {

    boolean register(String username, String password) throws UsernameAlreadyPresentException;

    boolean delete(String username) throws UserDoesNotExistsException;
}
