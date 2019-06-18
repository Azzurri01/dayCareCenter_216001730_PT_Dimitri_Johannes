package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.City;
import com.djohannes.ac.za.repository.CityRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("CityMemory")
public class CityRepositoryImpl implements CityRepository {

    private static CityRepositoryImpl repository = null;
    private Set<City> cities;

    private CityRepositoryImpl() {
        this.cities = new HashSet<>();
    }

    private City findCity(String cityId) {
        return this.cities.stream()
                .filter(city -> city.getId().trim().equals(cityId))
                .findAny()
                .orElse(null);
    }

    public static CityRepositoryImpl getRepository(){
        if(repository == null) repository = new CityRepositoryImpl();
        return repository;
    }

    public City create(City city){
        this.cities.add(city);
        return city;
    }

    public City read(final String cityId){
        //find the student in the set and return it if it exist
        City city = findCity(cityId);
        return city;
    }

    public City update(City city) {
        // find the student, update it and return the updated student
        City toDelete = findCity(city.getId());
        if(toDelete != null) {
            this.cities.remove(toDelete);
            return create(city);
        }
        return null;
    }

    public void delete(String cityId) {
        //find the student and delete it if it exists
        City city = findCity(cityId);
        if (city != null) this.cities.remove(city);
    }

    public Set<City> getAll(){
        return this.cities;
    }
}