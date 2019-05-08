package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Suburb;
import com.djohannes.ac.za.repository.SuburbRepository;
import com.djohannes.ac.za.repository.impl.SuburbRepositoryImpl;
import com.djohannes.ac.za.service.SuburbService;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class SuburbServiceImpl implements SuburbService {

    private static SuburbServiceImpl service = null;
    private SuburbRepository repository;

    private SuburbServiceImpl() {
        this.repository = SuburbRepositoryImpl.getRepository();
    }

    public static SuburbServiceImpl getService(){
        if (service == null) service = new SuburbServiceImpl();
        return service;
    }

    @Override
    public Suburb create(Suburb suburb) {
        return this.repository.create(suburb);
    }

    @Override
    public Suburb update(Suburb suburb) {
        return this.repository.update(suburb);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Suburb read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Suburb> getAll() {
        return this.repository.getAll();
    }
}