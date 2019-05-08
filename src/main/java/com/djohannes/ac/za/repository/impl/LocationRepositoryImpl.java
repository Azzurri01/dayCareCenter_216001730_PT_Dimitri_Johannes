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

    private Location findLocation(String locationId) {
        return this.locations.stream()
                .filter(location -> location.getId().trim().equals(locationId))
                .findAny()
                .orElse(null);
    }

    public static LocationRepositoryImpl getRepository(){
        if(repository == null) repository = new LocationRepositoryImpl();
        return repository;
    }

    public Location create(Location location){
        this.locations.add(location);
        return location;
    }

    public Location read(final String locationId){
        //find the student in the set and return it if it exist
        Location location = findLocation(locationId);
        return location;
    }

    public Location update(Location location) {
        // find the student, update it and return the updated student
        Location toDelete = findLocation(location.getId());
        if(toDelete != null) {
            this.locations.remove(toDelete);
            return create(location);
        }
        return null;
    }

    public void delete(String locationId) {
        //find the student and delete it if it exists
        Location location = findLocation(locationId);
        if (location != null) this.locations.remove(location);
    }

    public Set<Location> getAll(){
        return this.locations;
    }
}