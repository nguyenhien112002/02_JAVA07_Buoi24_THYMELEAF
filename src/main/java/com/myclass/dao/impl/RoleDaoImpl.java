package com.myclass.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myclass.connection.JDBCConnection;
import com.myclass.controller.RoleDao;
import com.myclass.database.JdbcConnection;
import com.myclass.entity.Role;

public class RoleDaoImpl implements RoleDao {
    @Autowired
    private JdbcConnection jbbcConnection;
    
    List<Role> roles = null;

    public RoleDaoImpl() {
        roles = new ArrayList<Role>();
        roles.add(new Role(1, "ROLE_ADMIN", "Quản trị hệ thống"));
        roles.add(new Role(2, "ROLE_TEACHER", " Giảng viên"));
        roles.add(new Role(3, "ROLE_STUDENT", "Học viên viên"));
    }

    public RoleDaoImpl(List<Role> roles) {
        super();
        this.roles = roles;
    }

    public List<Role> findAll1() {
        return roles;
    }
    public List<Role> findAll() {
        List<Role> roles = new ArrayList<Role>();
        Connection conn = jbbcConnection.getConnection();
        try  {

            String query = "Select * From roles";
            // Tạo câu lệnh truy vấn sử dụng đối tượng PreparedStatemetn
            PreparedStatement statement = conn.prepareStatement(query);

            // Thực thi câu lệnh truy vấn =>tạo đối tượng ResultSet lưu trữ tạm thời dữ liệu
            // lấy ra từ database
            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                Role role = new Role();
                role.setId(resultset.getInt("id"));
                role.setName(resultset.getString("name"));
                role.setDescription(resultset.getString("description"));
                // Thêm vào danh sách
                roles.add(role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;

    }

    public Role findByID(int id) {
        for (Role role : roles) {
            if (role.getId() == id)
                return role;
        }
        return null;
    }

    public void add(Role entity) {
        roles.add(entity);
    }

    public void update(Role entity) {
        Role role = new Role();
        role = findByID(entity.getId());
        if (role != null) {
            role.setName(entity.getName());
            role.setDescription(entity.getDescription());
        }
    }

    public void delete(int id) {
        for (Role role : roles) {
            if (role.getId() == id)
                roles.remove(role);
            break;
        }
    }

}
