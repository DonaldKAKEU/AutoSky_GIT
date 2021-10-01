package com.skysoft.autosky.service;


import com.skysoft.autosky.repository.DepanageRepositoryProxy;
import model.Depanage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepanageServiceProxy {

    @Autowired
    DepanageRepositoryProxy depanageRepositoryProxy;


    public Iterable<Depanage> getAllDepanage() {
        return depanageRepositoryProxy.findAllDepanage();
    }
}
