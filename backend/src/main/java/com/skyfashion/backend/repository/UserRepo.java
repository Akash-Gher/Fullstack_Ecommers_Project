package com.skyfashion.backend.repository;


import com.skyfashion.backend.entity.User;

public interface UserRepo {
    public User findByName(String name);
    public void add(User user);
}
