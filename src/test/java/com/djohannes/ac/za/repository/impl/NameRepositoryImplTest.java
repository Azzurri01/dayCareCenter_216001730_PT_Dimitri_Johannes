/*package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.NameRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NameRepositoryImplTest {

    private NameRepository repository;
    private Name name;

    private Name getSavedName()
    {
        Set<Name> savedName = this.repository.getAll();
        return  savedName.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = NameRepositoryImpl.getRepository();
        this.name = NameFactory.getName("Dimitri", "Johannes");
    }

    @Test
    public void aCreate()
    {
        Name createdName = this.repository.create(this.name);
        System.out.println("Create method called: Created name = " + this.name);
        dGetAll();
        Assert.assertSame(createdName, this.name);
    }

    @Test
    public void bRead()
    {
        Name savedName = getSavedName();
        System.out.println("Read method call 1: Reading nameID = " + savedName.getId());
        Name readName = this.repository.read(savedName.getId());
        System.out.println("Read method call 2: Reading read = " + savedName.getId());
        dGetAll();
        Assert.assertSame(savedName, readName);
    }

    @Test
    public void cUpdate()
    {
        String nm = "Jegels";
        Name newName = new Name.Builder().copy(getSavedName()).surname(nm).build();
        System.out.println("In update, about_to_updated = " + newName);
        Name updated = this.repository.update(newName);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated);
        dGetAll();
    }

    @Test
    public void eDelete()
    {
        Name savedName = getSavedName();
        this.repository.delete(savedName.getId());
        dGetAll();
    }

    @Test
    public void dGetAll()
    {
        Set<Name> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}*/