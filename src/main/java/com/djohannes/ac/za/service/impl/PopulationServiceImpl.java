package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.repository.PopulationRepository;
//import com.djohannes.ac.za.repository.impl.PopulationRepositoryImpl;
import com.djohannes.ac.za.service.PopulationService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("PopulationServiceImpl")
public class PopulationServiceImpl implements PopulationService {

    private static PopulationServiceImpl service = null;

    @Autowired
    //@Qualifier("PopulationMemory")
    private PopulationRepository repository;

    public static PopulationServiceImpl getService(){
        if (service == null) service = new PopulationServiceImpl();
        return service;
    }

    @Override
    public Population create(Population population) {
        return this.repository.save(population);
    }

    @Override
    public Population update(Population population) {
        return this.repository.save(population);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Population read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Population> getAll() {
        return this.repository.findAll();
    }
}