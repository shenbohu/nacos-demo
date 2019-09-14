package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();

    public User findById(int id);
}
