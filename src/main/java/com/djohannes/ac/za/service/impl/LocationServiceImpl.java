package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Location;
import com.djohannes.ac.za.repository.LocationRepository;
import com.djohannes.ac.za.repository.impl.LocationRepositoryImpl;
import com.djohannes.ac.za.service.LocationService;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private static LocationServiceImpl service = null;
    private LocationRepository repository;

    private LocationServiceImpl() {
        this.repository = LocationRepositoryImpl.getRepository();
    }

    public static LocationServiceImpl getService(){
        if (service == null) service = new LocationServiceImpl();
        return service;
    }

    @Override
    public Location create(Location location) {
        return this.repository.create(location);
    }

    @Override
    public Location update(Location location) {
        return this.repository.update(location);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Location read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Location> getAll() {
        return this.repository.getAll();
    }
}