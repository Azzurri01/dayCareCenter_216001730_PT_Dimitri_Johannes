package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Clinic;
import com.djohannes.ac.za.repository.ClinicRepository;

import java.util.HashSet;
import java.util.Set;

public class ClinicRepositoryImpl implements ClinicRepository {

    private static ClinicRepositoryImpl repository = null;
    private Set<Clinic> clinics;

    private ClinicRepositoryImpl() {
        this.clinics = new HashSet<>();
    }

    public static ClinicRepository getRepository(){
        if(repository == null) repository = new ClinicRepositoryImpl();
        return repository;
    }

    public Clinic create(Clinic clinic){
        this.clinics.add(clinic);
        return clinic;
    }

    public Clinic read(String clinicId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Clinic update(Clinic clinic) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String clinicId) {
        //find the student and delete it if it exists

    }

    public Set<Clinic> getAll(){
        return this.clinics;
    }
}