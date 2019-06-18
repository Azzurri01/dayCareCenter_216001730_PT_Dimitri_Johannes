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

    Name name = NameFactory.getName("Heideveld");
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
        dGetAll();
        Assert.assertSame(createdSuburb, this.suburb);
    }

    @Test
    public void bRead()
    {
        Suburb savedSuburb = getSavedSuburb();
        System.out.println("Read method call 1: Reading suburbID = " + savedSuburb.getId());
        Suburb readSuburb = this.repository.read(savedSuburb.getId());
        System.out.println("Read method call 2: Reading read = " + savedSuburb.getId());
        dGetAll();
        Assert.assertSame(savedSuburb, readSuburb);
    }

    @Test
    public void cUpdate()
    {
        Population tot = PopulationFactory.getTotal(3000000);
        Suburb newTotal = new Suburb.Builder().copy(getSavedSuburb()).population(tot).build();
        System.out.println("In update, about_to_updated = " + newTotal);
        Suburb updated = this.repository.update(newTotal);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newTotal, updated);
        dGetAll();
    }

    @Test
    public void eDelete()
    {
        Suburb savedSuburb = getSavedSuburb();
        this.repository.delete(savedSuburb.getId());
        dGetAll();
    }

    @Test
    public void dGetAll()
    {
        Set<Suburb> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}