package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Location;
import com.djohannes.ac.za.repository.LocationRepository;

import java.util.HashSet;
import java.util.Set;

public class LocationRepositoryImpl implements LocationRepository {

    private static LocationRepositoryImpl repository = null;
    private Set<Location> locations;

    private LocationRepositoryImpl() {
        this.locations = new HashSet<>();
    }

    public static LocationRepository getRepository(){
        if(repository == null) repository = new LocationRepositoryImpl();
        return repository;
    }

    public Location create(Location location){
        this.locations.add(location);
        return location;
    }

    public Location read(String locationId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Location update(Location location) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String locationId) {
        //find the student and delete it if it exists

    }

    public Set<Location> getAll(){
        return this.locations;
    }
}