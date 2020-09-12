package com.myclass.dao;


import com.myclass.entity.User;

public interface UserDao extends GenericDao<User, Integer>{
   User findByEmail(String email);
}
