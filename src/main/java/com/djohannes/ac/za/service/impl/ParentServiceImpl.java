package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Parent;
import com.djohannes.ac.za.repository.ParentRepository;
import com.djohannes.ac.za.repository.impl.ParentRepositoryImpl;
import com.djohannes.ac.za.service.ParentService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ParentServiceImpl")
public class ParentServiceImpl implements ParentService {

    private static ParentServiceImpl service = null;

    @Autowired
    @Qualifier("ParentMemory")
    private ParentRepository repository;

    private ParentServiceImpl() {
        this.repository = ParentRepositoryImpl.getRepository();
    }

    public static ParentServiceImpl getService(){
        if (service == null) service = new ParentServiceImpl();
        return service;
    }

    @Override
    public Parent create(Parent parent) {
        return this.repository.create(parent);
    }

    @Override
    public Parent update(Parent parent) {
        return this.repository.update(parent);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Parent read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Parent> getAll() {
        return this.repository.getAll();
    }
}