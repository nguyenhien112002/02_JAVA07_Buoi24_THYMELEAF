package com.myclass.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.myclass.controller.RoleDao;
import com.myclass.entity.Role;

@Transactional(rollbackOn = Exception.class)
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    public RoleDaoImpl() {
    }

    public RoleDaoImpl(List<Role> roles) {
    }

    public List<Role> findAll() {
        List<Role> roles = new ArrayList<Role>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query<Role> query = session.createQuery("FROM Role", Role.class);// làm việc với class entity
            roles = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    public Role findByID(int id) {
        Role role = new Role();
        String hql = "FROM Role Where id = :id";
        try {
            Session session = sessionFactory.getCurrentSession();
            Query<Role> query = session.createQuery(hql, Role.class);
            query.setParameter("id", id);
            role = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

    public void addOrUpdate(Role entity) {
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
            Role role = session.find(Role.class, id);
            if (role != null) {
                session.remove(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
