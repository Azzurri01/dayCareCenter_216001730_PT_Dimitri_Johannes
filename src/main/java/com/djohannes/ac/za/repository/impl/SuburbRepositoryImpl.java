/*package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Suburb;
import com.djohannes.ac.za.repository.SuburbRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("SuburbMemory")
public class SuburbRepositoryImpl implements SuburbRepository {

    private static SuburbRepositoryImpl repository = null;
    private Set<Suburb> suburbs;

    private SuburbRepositoryImpl() {
        this.suburbs = new HashSet<>();
    }

    private Suburb findSuburb(String suburbId) {
        return this.suburbs.stream()
                .filter(suburb -> suburb.getId().trim().equals(suburbId))
                .findAny()
                .orElse(null);
    }

    public static SuburbRepositoryImpl getRepository(){
        if(repository == null) repository = new SuburbRepositoryImpl();
        return repository;
    }

    public Suburb create(Suburb suburb){
        this.suburbs.add(suburb);
        return suburb;
    }

    public Suburb read(final String suburbId){
        //find the student in the set and return it if it exist
        Suburb suburb = findSuburb(suburbId);
        return suburb;
    }

    public Suburb update(Suburb suburb) {
        // find the student, update it and return the updated student
        Suburb toDelete = findSuburb(suburb.getId());
        if(toDelete != null) {
            this.suburbs.remove(toDelete);
            return create(suburb);
        }
        return null;
    }

    public void delete(String suburbId) {
        //find the student and delete it if it exists
        Suburb suburb = findSuburb(suburbId);
        if (suburb != null) this.suburbs.remove(suburb);
    }

    public Set<Suburb> getAll(){
        return this.suburbs;
    }
}*/