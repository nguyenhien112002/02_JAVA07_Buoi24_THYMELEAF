package com.myclass.dao;

import java.util.List;

import com.myclass.entity.Role;
import com.myclass.entity.User;

public interface UserDao {
    List<User> findAll();

    User findByID(int id);

    void addOrUpdate(User entity);

    void delete(int id);
}
