package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Counting;
import com.djohannes.ac.za.repository.CountingRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("CountingMemory")
public class CountingRepositoryImpl implements CountingRepository {

    private static CountingRepositoryImpl repository = null;
    private Set<Counting> numbers;

    private CountingRepositoryImpl() {
        this.numbers = new HashSet<>();
    }

    private Counting findCounting(String countingId) {
        return this.numbers.stream()
                .filter(counting -> counting.getId().trim().equals(countingId))
                .findAny()
                .orElse(null);
    }

    public static CountingRepositoryImpl getRepository(){
        if(repository == null) repository = new CountingRepositoryImpl();
        return repository;
    }

    public Counting create(Counting counting){
        this.numbers.add(counting);
        return counting;
    }

    public Counting read(final String countingId){
        //find the student in the set and return it if it exist
        Counting counting = findCounting(countingId);
        return counting;
    }

    public Counting update(Counting counting) {
        // find the student, update it and return the updated student
        Counting toDelete = findCounting(counting.getId());
        if(toDelete != null) {
            this.numbers.remove(toDelete);
            return create(counting);
        }
        return null;
    }

    public void delete(String countingId) {
        //find the student and delete it if it exists
        Counting counting = findCounting(countingId);
        if (counting != null) this.numbers.remove(counting);
    }

    public Set<Counting> getAll(){
        return this.numbers;
    }
}