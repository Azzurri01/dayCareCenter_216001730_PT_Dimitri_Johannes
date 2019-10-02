package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Parent;
import com.djohannes.ac.za.repository.ParentRepository;
import com.djohannes.ac.za.service.ParentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ParentServiceImpl")
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentRepository repository;

    @Override
    public Parent create(Parent parent) {
        return this.repository.save(parent);
    }

    @Override
    public Parent update(Parent parent) {
        return this.repository.save(parent);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Parent read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Parent> getAll() {
        return this.repository.findAll();
    }
}