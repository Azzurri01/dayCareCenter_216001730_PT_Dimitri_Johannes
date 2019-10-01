package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Suburb;
import com.djohannes.ac.za.repository.SuburbRepository;
//import com.djohannes.ac.za.repository.impl.SuburbRepositoryImpl;
import com.djohannes.ac.za.service.SuburbService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("SuburbServiceImpl")
public class SuburbServiceImpl implements SuburbService {

    private static SuburbServiceImpl service = null;

    @Autowired
    //@Qualifier("SuburbMemory")
    private SuburbRepository repository;

    public static SuburbServiceImpl getService(){
        if (service == null) service = new SuburbServiceImpl();
        return service;
    }

    @Override
    public Suburb create(Suburb suburb) {
        return this.repository.save(suburb);
    }

    @Override
    public Suburb update(Suburb suburb) {
        return this.repository.save(suburb);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Suburb read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Suburb> getAll() {
        return this.repository.findAll();
    }
}