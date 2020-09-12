package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myclass.dao.RoleDao;
import com.myclass.dao.UserDao;
import com.myclass.entity.Role;
import com.myclass.entity.User;

@Controller
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserDao userDao;
    
    @RequestMapping(value="", method=RequestMethod.GET)
    public String index(Model model) {
        List<User> users = userDao.findAll();
        System.out.println(users);
        System.out.println("test");
        //chuyen tiep danh sach role qua trang index.html
        //model.addAllAttributes("roles",roles);
        model.addAttribute("users",users);
        return "user/index";
    }
    
    @RequestMapping(value="add", method=RequestMethod.GET)
    public String add() {
        return "user/add";
    }
}
