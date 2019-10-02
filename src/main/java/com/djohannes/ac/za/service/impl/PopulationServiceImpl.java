package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.repository.PopulationRepository;
import com.djohannes.ac.za.service.PopulationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PopulationServiceImpl")
public class PopulationServiceImpl implements PopulationService {

    @Autowired
    private PopulationRepository repository;

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