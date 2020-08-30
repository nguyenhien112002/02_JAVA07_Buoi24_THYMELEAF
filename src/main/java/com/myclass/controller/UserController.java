package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping(value="", method=RequestMethod.GET)
    public String index() {
        return "user/index";
    }
    @RequestMapping(value="add", method=RequestMethod.GET)
    public String add() {
        return "user/add";
    }
}
