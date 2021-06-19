package com.example.social.repository;

import com.example.social.exceptions.UserDoesNotExistsException;
import com.example.social.exceptions.UsernameAlreadyPresentException;

public interface AuthenticationRepository {
    boolean validate(String username, String password);
    boolean register(String username, String password) throws UsernameAlreadyPresentException;
    boolean delete(String username) throws UserDoesNotExistsException;
}
