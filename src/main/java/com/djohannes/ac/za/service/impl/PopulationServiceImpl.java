package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.repository.PopulationRepository;
import com.djohannes.ac.za.repository.impl.PopulationRepositoryImpl;
import com.djohannes.ac.za.service.PopulationService;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class PopulationServiceImpl implements PopulationService {

    private static PopulationServiceImpl service = null;
    private PopulationRepository repository;

    private PopulationServiceImpl() {
        this.repository = PopulationRepositoryImpl.getRepository();
    }

    public static PopulationServiceImpl getService(){
        if (service == null) service = new PopulationServiceImpl();
        return service;
    }

    @Override
    public Population create(Population population) {
        return this.repository.create(population);
    }

    @Override
    public Population update(Population population) {
        return this.repository.update(population);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Population read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Population> getAll() {
        return this.repository.getAll();
    }
}