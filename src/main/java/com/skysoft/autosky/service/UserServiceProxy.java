package com.skysoft.autosky.service;

import com.skysoft.autosky.repository.DepanageRepositoryProxy;
import com.skysoft.autosky.repository.UserRepositoryProxy;
import model.Depanage;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.PrimitiveIterator;


@Service
public class UserServiceProxy {

    @Autowired
    UserRepositoryProxy userRepositoryProxy;


    public Iterable<User> getAllUsers(){
       return userRepositoryProxy.findAllUsers();
    }

    public User createUser( User u) {
          User us = userRepositoryProxy.createUrl(u);
          return us;
    }

    public void deleteUserById(Long id){

        userRepositoryProxy.deleteUrl(id);
    }

}
