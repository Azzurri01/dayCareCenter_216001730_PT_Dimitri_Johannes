package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.City;
import com.djohannes.ac.za.repository.CityRepository;
import com.djohannes.ac.za.service.CityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CityServiceImpl")
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository repository;

    @Override
    public City create(City city) {
        return this.repository.save(city);
    }

    @Override
    public City update(City city) {
        return this.repository.save(city);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public City read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<City> getAll() {
        return this.repository.findAll();
    }
}