package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.repository.NameRepository;
//import com.djohannes.ac.za.repository.impl.NameRepositoryImpl;
import com.djohannes.ac.za.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service("NameServiceImpl")
public class NameServiceImpl implements NameService {

    private static NameServiceImpl service = null;

    @Autowired
    //@Qualifier("NameMemory")
    private NameRepository repository;

    public static NameServiceImpl getService(){
        if (service == null) service = new NameServiceImpl();
        return service;
    }

    @Override
    public Name create(Name name) {
        return this.repository.save(name);
    }

    @Override
    public Name update(Name name) {
        return this.repository.save(name);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Name read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Name> getAll() {
        return this.repository.findAll();
    }
}