package com.example.social.repository;

import com.example.social.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private Map<String, AppUser> users = new HashMap<>();


    @Override
    public AppUser getByid(String username) {
        return users.get(username);
    }

    @Override
    public AppUser save(AppUser appUser) {
        return users.put(appUser.getUsername(), appUser);
    }

    @Override
    public boolean delete(String username) {
        users.remove(username);
        return true;
    }
}
