package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.domain.Suburb;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.SuburbRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SuburbRepositoryImplTest {

    private SuburbRepository repository;
    private Suburb suburb;

    Name name = NameFactory.schoolName("Heideveld");
    Population population = PopulationFactory.getTotal(100000);

    private Suburb getSavedSuburb()
    {
        Set<Suburb> savedSuburb = this.repository.getAll();
        return  savedSuburb.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = SuburbRepositoryImpl.getRepository();
        this.suburb = SuburbFactory.getSuburb("7764", name, population);
    }

    @Test
    public void aCreate()
    {
        Suburb createdSuburb = this.repository.create(this.suburb);
        System.out.println("Create method called: Created suburb = " + this.suburb);
        eGetAll();
        Assert.assertSame(createdSuburb, this.suburb);
    }

    @Test
    public void bRead()
    {
        Suburb savedSuburb = getSavedSuburb();
        System.out.println("Read method call 1: Reading suburbID = " + savedSuburb.getId());
        Suburb readSuburb = this.repository.read(savedSuburb.getId());
        System.out.println("Read method call 2: Reading read = " + savedSuburb.getId());
        eGetAll();
        Assert.assertSame(savedSuburb, readSuburb);
    }

    @Test
    public void cUpdate()
    {
        String newId = "112";
        Suburb streetNo = new Suburb.Builder().copy(getSavedSuburb()).id(newId).build();
        System.out.println("In update, about_to_updated = " + suburb);
        Suburb updated = this.repository.update(suburb);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId().toString());;
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Suburb savedSuburb = getSavedSuburb();
        this.repository.delete(savedSuburb.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Suburb> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}