package com.myclass.controller;

import java.util.List;

import com.myclass.entity.Role;

public interface RoleDao {
    List<Role> findAll();
    Role findByID(int id);
    void addOrUpdate(Role entity);
    void delete(int id);

}
