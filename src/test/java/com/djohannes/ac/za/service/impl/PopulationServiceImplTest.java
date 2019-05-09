package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.PopulationRepository;
import com.djohannes.ac.za.repository.impl.PopulationRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class PopulationServiceImplTest {

    private PopulationRepository repository;
    private Population population;

    private Population getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = PopulationRepositoryImpl.getRepository();
        this.population = PopulationFactory.getTotal(1000000);
    }

    @Test
    public void aCreate()
    {
        Population created = this.repository.create(this.population);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.population);
    }

    @Test
    public void bUpdate()
    {
        String newPopulationId = "123";
        Population updated = new Population.Builder().copy(getSaved()).id(newPopulationId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newPopulationId, updated.getId());
    }

    @Test
    public void cDelete()
    {
        Population saved = getSaved();
        this.repository.delete(saved.getId());
        eGetAll();
    }

    @Test
    public void dRead()
    {
        Population saved = getSaved();
        Population read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void eGetAll()
    {
        Set<Population> populations = this.repository.getAll();
        System.out.println("In getall, all = " + populations);
    }
}