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
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }

    public User findByEmail(String email) {
        User entity = new User();
        String hql = "FROM Role Where email = :email";
        try {
            Session session = sessionFactory.getCurrentSession();
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("email", email);
            entity = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
}
