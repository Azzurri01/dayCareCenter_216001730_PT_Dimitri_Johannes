package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.factory.PopulationFactory;
import com.djohannes.ac.za.repository.PopulationRepository;
import com.djohannes.ac.za.util.Misc;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PopulationRepositoryImplTest {

    private PopulationRepository repository;
    private Population population;

    private Population getSavedPopulation()
    {
        Set<Population> savedPopulation = this.repository.getAll();
        return  savedPopulation.iterator().next();
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
        Population createdPopulation = this.repository.create(this.population);
        System.out.println("Create method called: Created population = " + this.population);
        eGetAll();
        Assert.assertSame(createdPopulation, this.population);
    }

    @Test
    public void bRead()
    {
        Population savedPopulation = getSavedPopulation();
        System.out.println("Read method call 1: Reading populationID = " + savedPopulation.getId());
        Population readPopulation = this.repository.read(savedPopulation.getId());
        System.out.println("Read method call 2: Reading read = " + savedPopulation);
        eGetAll();
        Assert.assertSame(savedPopulation, readPopulation);
    }

    @Test
    public void cUpdate()
    {
        //New total
        int newTotal = 150000;

        //Add new total into object
        Population total = new Population.Builder().copy(getSavedPopulation()).population(newTotal).build();
        System.out.println("In update, about_to_updated = " + total);

        //Update object
        Population updated = this.repository.update(total);
        System.out.println("In update, updated = " + updated);

        //Test new value against method
        Assert.assertEquals(newTotal, updated.getTotal());
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Population savedPopulation = getSavedPopulation();
        this.repository.delete(savedPopulation.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Population> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}