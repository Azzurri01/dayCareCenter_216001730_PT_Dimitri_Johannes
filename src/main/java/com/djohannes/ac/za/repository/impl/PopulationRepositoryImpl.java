package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.repository.PopulationRepository;

import java.util.HashSet;
import java.util.Set;

public class PopulationRepositoryImpl implements PopulationRepository {

    private static PopulationRepositoryImpl repository = null;
    private Set<Population> populations;

    private PopulationRepositoryImpl() {
        this.populations = new HashSet<>();
    }

    private Population findPopulation(String populationId) {
        return this.populations.stream()
                .filter(population -> population.getId().trim().equals(populationId))
                .findAny()
                .orElse(null);
    }

    public static PopulationRepositoryImpl getRepository(){
        if(repository == null) repository = new PopulationRepositoryImpl();
        return repository;
    }

    public Population create(Population population){
        this.populations.add(population);
        return population;
    }

    public Population read(final String populationId){
        //find the student in the set and return it if it exist
        Population population = findPopulation(populationId);
        return population;
    }

    public Population update(Population population) {
        // find the student, update it and return the updated student
        Population toDelete = findPopulation(population.getId());
        if(toDelete != null) {
            this.populations.remove(toDelete);
            return create(population);
        }
        return null;
    }

    public void delete(String populationId) {
        //find the student and delete it if it exists
        Population population = findPopulation(populationId);
        if (population != null) this.populations.remove(population);
    }

    public Set<Population> getAll(){
        return this.populations;
    }
}