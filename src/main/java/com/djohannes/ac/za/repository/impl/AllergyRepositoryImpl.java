package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Allergy;
import com.djohannes.ac.za.repository.AllergyRepository;

import java.util.HashSet;
import java.util.Set;

public class AllergyRepositoryImpl implements AllergyRepository {

    private static AllergyRepositoryImpl repository = null;
    private Set<Allergy> allergies;

    private AllergyRepositoryImpl() {
        this.allergies = new HashSet<>();
    }

    public static AllergyRepository getRepository(){
        if(repository == null) repository = new AllergyRepositoryImpl();
        return repository;
    }

    public Allergy create(Allergy allergy ){
        this.allergies.add(allergy);
        return allergy;
    }

    public Allergy read(String activityId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Allergy update(Allergy allergy) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String allergyId) {
        //find the student and delete it if it exists

    }

    public Set<Allergy> getAll(){
        return this.allergies;
    }
}
