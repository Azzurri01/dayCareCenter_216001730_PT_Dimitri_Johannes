package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Daycare;
import com.djohannes.ac.za.repository.DaycareRepository;

import java.util.HashSet;
import java.util.Set;

public class DaycareRepositoryImpl implements DaycareRepository {

    private static DaycareRepositoryImpl repository = null;
    private Set<Daycare> daycares;

    private DaycareRepositoryImpl() {
        this.daycares = new HashSet<>();
    }

    public static DaycareRepository getRepository(){
        if(repository == null) repository = new DaycareRepositoryImpl();
        return repository;
    }

    public Daycare create(Daycare daycare){
        this.daycares.add(daycare);
        return daycare;
    }

    public Daycare read(String daycareId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Daycare update(Daycare daycare) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String daycareId) {
        //find the student and delete it if it exists

    }

    public Set<Daycare> getAll(){
        return this.daycares;
    }
}