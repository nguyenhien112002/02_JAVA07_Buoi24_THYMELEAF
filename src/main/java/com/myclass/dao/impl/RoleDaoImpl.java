package com.myclass.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.myclass.connection.JdbcConnection;
import com.myclass.controller.RoleDao;
import com.myclass.entity.Role;

public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Role> findAll() {
        List<Role> roles = new ArrayList<Role>();
        try {
            Session session = sessionFactory.openSession();
            Query<Role> query = session.createQuery("FROM Role", Role.class);// làm việc với class entity
            roles = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    public RoleDaoImpl() {
    }

    public RoleDaoImpl(List<Role> roles) {
    }

    public Role findByID(int id) {
        Role role = new Role();
        String hql = "FROM Role Where id = :id";
        try {
            Session session = sessionFactory.openSession();
            Query<Role> query = session.createQuery(hql, Role.class);
            query.setParameter("id", id);
            role = query.getSingleResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

    public void addOrUpdate(Role entity) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void delete(int id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Role role = session.find(Role.class, id);
            if (role != null) {
                session.remove(role);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }
    }

}
