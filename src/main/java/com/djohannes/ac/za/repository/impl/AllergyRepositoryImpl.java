package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Allergy;
import com.djohannes.ac.za.repository.AllergyRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("AllergyMemory")
public class AllergyRepositoryImpl implements AllergyRepository {

    private static AllergyRepositoryImpl repository = null;
    private Set<Allergy> allergies;

    private AllergyRepositoryImpl() {
        this.allergies = new HashSet<>();
    }

    private Allergy findAllergy(String allergyId) {
        return this.allergies.stream()
                .filter(allergy -> allergy.getId().trim().equals(allergyId))
                .findAny()
                .orElse(null);
    }

    public static AllergyRepositoryImpl getRepository(){
        if(repository == null) repository = new AllergyRepositoryImpl();
        return repository;
    }

    public Allergy create(Allergy allergy){
        this.allergies.add(allergy);
        return allergy;
    }

    public Allergy read(final String allergyId){
        //find the student in the set and return it if it exist
        Allergy allergy = findAllergy(allergyId);
        return allergy;
    }

    public Allergy update(Allergy allergy) {
        // find the student, update it and return the updated student
        Allergy toDelete = findAllergy(allergy.getId());
        if(toDelete != null) {
            this.allergies.remove(toDelete);
            return create(allergy);
        }
        return null;
    }

    public void delete(String allergyId) {
        //find the student and delete it if it exists
        Allergy allergy = findAllergy(allergyId);
        if (allergy != null) this.allergies.remove(allergy);
    }

    public Set<Allergy> getAll(){
        return this.allergies;
    }
}
