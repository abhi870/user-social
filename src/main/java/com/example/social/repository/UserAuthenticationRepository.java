package com.example.social.repository;

import com.example.social.exceptions.UserDoesNotExistsException;
import com.example.social.exceptions.UsernameAlreadyPresentException;
import com.example.social.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.social.constants.ExceptionConstants.USER_DOES_NOT_EXISTS;
import static com.example.social.constants.ExceptionConstants.USER_NAME_NOT_AVAILABLE;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAuthenticationRepository implements AuthenticationRepository {
    private static final Map<String, String> authMap = new HashMap<>();

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean validate(String username, String password) {
        return authMap.get(username).equals(password);
    }

    @Override
    public boolean register(String username, String password) throws UsernameAlreadyPresentException {
        if (checkUserNamePresentInSystem(username))
            throw new UsernameAlreadyPresentException(USER_NAME_NOT_AVAILABLE);
        authMap.put(username, password);
        userRepository.save(createNewUser(username, password));
        return true;
    }

    @Override
    public boolean delete(String username) throws UserDoesNotExistsException {
        if (!checkUserNamePresentInSystem(username))
            throw new UserDoesNotExistsException(USER_DOES_NOT_EXISTS);
        authMap.remove(username);
        userRepository.delete(username);
        return false;
    }

    private boolean checkUserNamePresentInSystem(String username) {
        return authMap.containsKey(username);
    }

    private AppUser createNewUser(String username, String password) {
        AppUser newUser = new AppUser();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setFollowing(new HashMap<>());
        newUser.setPosts(new ArrayList<>());
        return newUser;
    }

}
