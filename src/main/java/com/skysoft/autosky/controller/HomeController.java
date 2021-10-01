package com.skysoft.autosky.controller;

import com.skysoft.autosky.service.DepanageServiceProxy;
import com.skysoft.autosky.service.UserServiceProxy;
import model.Depanage;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    DepanageServiceProxy depanageServiceProxy;
    @Autowired
    UserServiceProxy userServiceProxy;

    @GetMapping("/home")
    public String affich(Model model) {


        Iterable<Depanage> listDepanage = depanageServiceProxy.getAllDepanage();


        model.addAttribute("Depanages", listDepanage);

     Iterable<User> listUsers = userServiceProxy.getAllUsers();


        model.addAttribute("Users", listUsers);

        return "home";
    }



}
   /* public Iterable<Depanage> getAllDepange(){
        return depanageRepositoryProxy.getAllDepanage();
    }*/

