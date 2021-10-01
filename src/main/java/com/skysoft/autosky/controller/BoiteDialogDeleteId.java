package com.skysoft.autosky.controller;

import com.skysoft.autosky.service.UserServiceProxy;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

public class BoiteDialogDeleteId {

    @Autowired
    UserServiceProxy userServiceProxy;

    @GetMapping("/deleteUserById")
    public String getId(Model model){


        model.addAttribute("idSupp", new User().getId());

        return "testForm";

    }

    @DeleteMapping("/deleteUserById")
    public void deleteUserById (@ModelAttribute Long id){

        userServiceProxy.deleteUserById(id);
    }




}
