package com.myclass.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.myclass.dao.RoleDao;
import com.myclass.entity.Role;
import com.myclass.entity.User;

@Transactional(rollbackOn = Exception.class)
public class RoleDaoImpl extends GenericDaoImpl<Role, Integer> implements RoleDao {
    public RoleDaoImpl() {
        super(Role.class);
    }

}
