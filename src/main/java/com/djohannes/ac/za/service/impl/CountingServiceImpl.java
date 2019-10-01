package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Counting;
import com.djohannes.ac.za.repository.CountingRepository;
//import com.djohannes.ac.za.repository.impl.CountingRepositoryImpl;
import com.djohannes.ac.za.service.CountingService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("CountingServiceImpl")
public class CountingServiceImpl implements CountingService {

    private static CountingServiceImpl service = null;

    @Autowired
    //@Qualifier("CountingMemory")
    private CountingRepository repository;

    public static CountingServiceImpl getService(){
        if (service == null) service = new CountingServiceImpl();
        return service;
    }

    @Override
    public Counting create(Counting counting) {
        return this.repository.save(counting);
    }

    @Override
    public Counting update(Counting counting) {
        return this.repository.save(counting);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Counting read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Counting> getAll() {
        return this.repository.findAll();
    }
}