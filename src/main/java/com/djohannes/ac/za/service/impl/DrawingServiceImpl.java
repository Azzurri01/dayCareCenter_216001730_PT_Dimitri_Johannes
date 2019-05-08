package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.City;
import com.djohannes.ac.za.repository.CityRepository;
import com.djohannes.ac.za.repository.impl.CityRepositoryImpl;
import com.djohannes.ac.za.service.CityService;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class DrawingServiceImpl implements CityService {

    private static DrawingServiceImpl service = null;
    private CityRepository repository;

    private DrawingServiceImpl() {
        this.repository = CityRepositoryImpl.getRepository();
    }

    public static DrawingServiceImpl getService(){
        if (service == null) service = new DrawingServiceImpl();
        return service;
    }

    @Override
    public City create(City city) {
        return this.repository.create(city);
    }

    @Override
    public City update(City city) {
        return this.repository.update(city);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public City read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<City> getAll() {
        return this.repository.getAll();
    }
}