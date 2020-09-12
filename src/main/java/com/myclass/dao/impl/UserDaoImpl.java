package com.myclass.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.myclass.dao.RoleDao;
import com.myclass.dao.UserDao;
import com.myclass.entity.User;

@Transactional(rollbackOn = Exception.class)
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    
    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query<User> query = session.createQuery("FROM User", User.class);
            users = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public User findByID(int id) {
        User user = new User();
        String hql = "FROM User Where id = :id";
        try {
            Session session = sessionFactory.getCurrentSession();
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("id", id);
            user = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addOrUpdate(User entity) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            User user = session.find(User.class, id);
            if (user != null) {
                session.remove(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
