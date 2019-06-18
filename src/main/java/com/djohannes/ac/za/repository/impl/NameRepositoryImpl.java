package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.repository.NameRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("NameMemory")
public class NameRepositoryImpl implements NameRepository
{
    //Local variables
    private static NameRepositoryImpl repository = null;
    private Set<Name> names;

    //Default constructor
    private NameRepositoryImpl()
    {
        this.names = new HashSet<>();
    }

    //Get repository
    public static NameRepositoryImpl getRepository()
    {
        if(repository == null) repository = new NameRepositoryImpl();
        return repository;
    }

    //Search for name
    private Name search(String nameId)
    {
        return this.names.stream()
                .filter(name -> name.getId().trim().equals(nameId))
                .findAny()
                .orElse(null);
    }

    //Create name object
    public Name create(Name name)
    {
        this.names.add(name);
        return name;
    }

    //Read name object
    public Name read(String nameId)
    {
        //find the name in the set and return it if it exist
        Name name = search(nameId);
        return name;
    }

    //Update name object
    public Name update(Name name)
    {
        // find the name, update it and return the updated name
        Name nameDelete = search(name.getId());
        if(nameDelete != null) {
            this.names.remove(nameDelete);
            return create(name);
        }
        return null;
    }

    //Delete name object
    public void delete(String nameId)
    {
        //find the name and delete it if it exists
        Name name = search(nameId);
        if (name != null)
            this.names.remove(name);
    }

    //Get All
    public Set<Name> getAll()
    {
        return this.names;
    }
}
