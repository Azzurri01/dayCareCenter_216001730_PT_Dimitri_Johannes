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

    private Daycare findDaycare(String daycareId) {
        /*return this.daycares.stream()
                .filter(daycare -> daycare.getNo().trim().equals(daycareId))
                .findAny()
                .orElse(null);*/
        return null;
    }

    public static DaycareRepositoryImpl getRepository(){
        if(repository == null) repository = new DaycareRepositoryImpl();
        return repository;
    }

    public Daycare create(Daycare daycare){
        this.daycares.add(daycare);
        return daycare;
    }

    public Daycare read(final String daycareId){
        //find the student in the set and return it if it exist
        Daycare daycare = findDaycare(daycareId);
        return daycare;
    }

    public Daycare update(Daycare daycare) {
        // find the student, update it and return the updated student
        Daycare toDelete = findDaycare(daycare.getID());
        if(toDelete != null) {
            this.daycares.remove(toDelete);
            return create(daycare);
        }
        return null;
    }

    public void delete(String daycareId) {
        //find the student and delete it if it exists
        Daycare daycare = findDaycare(daycareId);
        if (daycare != null) this.daycares.remove(daycare);
    }

    public Set<Daycare> getAll(){
        return this.daycares;
    }
}