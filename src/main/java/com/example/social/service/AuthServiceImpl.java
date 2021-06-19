package com.example.social.service;

import com.example.social.exceptions.UserDoesNotExistsException;
import com.example.social.exceptions.UsernameAlreadyPresentException;
import com.example.social.repository.AuthenticationRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Override
    public boolean register(String username, String password) throws UsernameAlreadyPresentException {
        authenticationRepository.register(username, password);
        return true;
    }

    @Override
    public boolean delete(String username) throws UserDoesNotExistsException {
        authenticationRepository.delete(username);
        return true;
    }
}
