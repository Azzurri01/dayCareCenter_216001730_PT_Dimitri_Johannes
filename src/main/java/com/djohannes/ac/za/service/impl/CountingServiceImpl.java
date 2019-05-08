package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Counting;
import com.djohannes.ac.za.repository.CountingRepository;
import com.djohannes.ac.za.repository.impl.CountingRepositoryImpl;
import com.djohannes.ac.za.service.CountingService;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class CountingServiceImpl implements CountingService {

    private static CountingServiceImpl service = null;
    private CountingRepository repository;

    private CountingServiceImpl() {
        this.repository = CountingRepositoryImpl.getRepository();
    }

    public static CountingServiceImpl getService(){
        if (service == null) service = new CountingServiceImpl();
        return service;
    }

    @Override
    public Counting create(Counting counting) {
        return this.repository.create(counting);
    }

    @Override
    public Counting update(Counting counting) {
        return this.repository.update(counting);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Counting read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Counting> getAll() {
        return this.repository.getAll();
    }
}