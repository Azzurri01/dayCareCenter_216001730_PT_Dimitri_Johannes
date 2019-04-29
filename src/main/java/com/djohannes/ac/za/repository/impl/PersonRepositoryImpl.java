package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Person;
import com.djohannes.ac.za.repository.PersonRepository;

import java.util.HashSet;
import java.util.Set;

public class PersonRepositoryImpl implements PersonRepository {

    private static PersonRepositoryImpl repository = null;
    private Set<Person> people;

    private PersonRepositoryImpl() {
        this.people = new HashSet<>();
    }

    public static PersonRepository getRepository(){
        if(repository == null) repository = new PersonRepositoryImpl();
        return repository;
    }

    public Person create(Person Person){
        this.people.add(Person);
        return Person;
    }

    public Person read(String PersonId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Person update(Person Person) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String PersonId) {
        //find the student and delete it if it exists

    }

    public Set<Person> getAll(){
        return this.people;
    }
}