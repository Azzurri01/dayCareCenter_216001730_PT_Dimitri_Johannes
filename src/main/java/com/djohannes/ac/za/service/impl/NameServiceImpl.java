package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.repository.NameRepository;
import com.djohannes.ac.za.repository.impl.NameRepositoryImpl;
import com.djohannes.ac.za.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service("ServiceImpl")
public class NameServiceImpl implements NameService {

    private static NameServiceImpl service = null;

    @Autowired
    @Qualifier("InMemory")
    private NameRepository repository;

    private NameServiceImpl() {
        this.repository = NameRepositoryImpl.getRepository();
    }

    public static NameServiceImpl getService(){
        if (service == null) service = new NameServiceImpl();
        return service;
    }

    @Override
    public Name create(Name name) {
        return this.repository.create(name);
    }

    @Override
    public Name update(Name name) {
        return this.repository.update(name);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Name read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Name> getAll() {
        return this.repository.getAll();
    }
}