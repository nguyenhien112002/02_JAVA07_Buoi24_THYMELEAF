package com.myclass.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;

import com.myclass.dao.GenericDao;
import com.myclass.entity.Role;

@Transactional(rollbackOn = Exception.class)
public abstract class GenericDaoImpl<T, K> implements GenericDao<T, K> {

    private final Class<T> clazz;
    protected final String clazzName;

    public GenericDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
        clazzName = clazz.getSimpleName();

    }

    @Autowired
    protected SessionFactory sessionFactory;

    public List<T> findAll() {
        List<T> entities = new ArrayList<T>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query<T> query = session.createQuery("FROM " + this.clazzName, clazz);// làm việc với class entity
            entities = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entities;
    }

    public T findByID(K id) {
        T entity = null;
        String hql = "FROM Role Where id = :id";
        try {
            Session session = sessionFactory.getCurrentSession();
            Query<T> query = session.createQuery(hql, this.clazz);
            query.setParameter("id", id);
            entity = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public void addOrUpdate(T entity) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(K id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            Role role = session.find(Role.class, id);
            if (role != null) {
                session.remove(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
