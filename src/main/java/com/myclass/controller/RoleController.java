package com.myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import com.myclass.entity.Role;

@Component
//@Controller
@RequestMapping("role")
public class RoleController {
    
    @Autowired
    private RoleDao roleDao;
    
    
    @RequestMapping(value ="", method=RequestMethod.GET)
    public String index(Model model) {
        //lay danh sach role
        List<Role> roles = roleDao.findAll();
        //chuyen tiep danh sach role qua trang index.html
        //model.addAllAttributes("roles",roles);
        model.addAttribute("roles",roles);
        return "role/index";
    }
    
    @RequestMapping(value ="add", method=RequestMethod.GET)
    public String add(Model model) {
        Role role = new Role();
        model.addAttribute("role", role);
        return "role/add";
    }
    
    
    @RequestMapping(value ="add", method=RequestMethod.POST)
    public String add(@ModelAttribute("role") Role role) {
        System.out.println("id: " + role.getId());
        System.out.println("id: " + role.getName());
        System.out.println("id: " + role.getDescription());
        roleDao.addOrUpdate(role);
        return "redirect:/role";
    }

    @RequestMapping(value ="edit", method=RequestMethod.GET)
    public String edit(@RequestParam("id") int id, Model model) {
        Role role = new Role();
        role = roleDao.findByID(id);
        model.addAttribute("role", role);
        return "role/edit";
    }
    
    @RequestMapping(value ="edit", method=RequestMethod.POST)
    public String edit(@ModelAttribute("role") Role role) {
        System.out.println("id: " + role.getId());
        System.out.println("id: " + role.getName());
        System.out.println("id: " + role.getDescription());
        roleDao.addOrUpdate(role);
        return "redirect:/role";
    }
    
    @RequestMapping(value ="delete", method=RequestMethod.GET)
    public String delete(@RequestParam("id") int id, Model model) {
        //Role role = new Role();
        roleDao.delete(id);
        return "redirect:/role";
    }
}
