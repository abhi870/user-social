package com.example.social.repository;

import com.example.social.model.AppUser;


public interface UserRepository {


    AppUser getByid(String username);

    AppUser save(AppUser appUser);

    boolean delete(String username);

}
