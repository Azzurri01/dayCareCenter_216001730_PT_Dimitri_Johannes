package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.City;
import com.djohannes.ac.za.repository.CityRepository;
//import com.djohannes.ac.za.repository.impl.CityRepositoryImpl;
import com.djohannes.ac.za.service.CityService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("CityServiceImpl")
public class CityServiceImpl implements CityService {

    private static CityServiceImpl service = null;

    @Autowired
    //@Qualifier("CityMemory")
    private CityRepository repository;

    public static CityServiceImpl getService(){
        if (service == null) service = new CityServiceImpl();
        return service;
    }

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