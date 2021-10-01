package com.skysoft.autosky.controller;

import com.skysoft.autosky.service.UserServiceProxy;
import model.User;
import org.attoparser.trace.MarkupTraceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.UnicodeEscaper;


@Controller
public class formCreateUser {

    @Autowired
    UserServiceProxy userServiceProxy;

    @GetMapping("/saveUser")
    public String getUserForm(Model model) {

        User u = new User();

        model.addAttribute("uName", u);

        return "formCreateUser";


    }


    @PostMapping("/saveUser")
    @ResponseBody
    public User saveEmployee(@ModelAttribute User u) {

        return userServiceProxy.createUser(u);

    }

}

/*if(u.getId() != null) {
        // Employee from update form has the password field not filled,
        // so we fill it with the current password.
        User current = UserServiceProxy.getUser(employee.getId());
        employee.setPassword(current.getPassword());
        }*/