package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Person;

import java.util.Set;

public interface PersonRepository extends IRepository<Person, String>
{
    Set<Person> getAll();
}