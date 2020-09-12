package com.myclass.dao;

import java.util.List;

import com.myclass.entity.Role;

public interface GenericDao<T, K> {
    List<T> findAll();

    T findByID(K id);

    void addOrUpdate(T entity);

    void delete(K id);
}
