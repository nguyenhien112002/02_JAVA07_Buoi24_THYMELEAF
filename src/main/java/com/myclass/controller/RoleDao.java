package com.myclass.controller;

import java.util.List;

import com.myclass.entity.Role;

public interface RoleDao {
    List<Role> findAll();
    Role findByID(int id);
    void add(Role entity);
    void update(Role entity);
    void delete(int id);

}
