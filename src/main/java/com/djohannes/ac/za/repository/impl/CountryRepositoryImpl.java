package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Country;
import com.djohannes.ac.za.repository.CountryRepository;

import java.util.HashSet;
import java.util.Set;

public class CountryRepositoryImpl implements CountryRepository {

    private static CountryRepositoryImpl repository = null;
    private Set<Country> countries;

    private CountryRepositoryImpl() {
        this.countries = new HashSet<>();
    }

    public static CountryRepository getRepository(){
        if(repository == null) repository = new CountryRepositoryImpl();
        return repository;
    }

    public Country create(Country country){
        this.countries.add(country);
        return country;
    }

    public Country read(String countryId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Country update(Country country) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String countryId) {
        //find the student and delete it if it exists

    }

    public Set<Country> getAll(){
        return this.countries;
    }
}