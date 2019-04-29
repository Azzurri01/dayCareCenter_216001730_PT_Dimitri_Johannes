package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.City;
import com.djohannes.ac.za.repository.CityRepository;

import java.util.HashSet;
import java.util.Set;

public class CityRepositoryImpl implements CityRepository {

    private static CityRepositoryImpl repository = null;
    private Set<City> cities;

    private CityRepositoryImpl() {
        this.cities = new HashSet<>();
    }

    public static CityRepository getRepository(){
        if(repository == null) repository = new CityRepositoryImpl();
        return repository;
    }

    public City create(City city){
        this.cities.add(city);
        return city;
    }

    public City read(String cityId){
        //find the student in the set and return it if it exist
        return null;
    }

    public City update(City city) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String cityId) {
        //find the student and delete it if it exists

    }

    public Set<City> getAll(){
        return this.cities;
    }
}