package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.PopulationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PopulationServiceImplTest {

    @Autowired
    @Qualifier("PopulationServiceImpl")
    private PopulationService populationService;
    private Population population;
    private Set<Population> populations = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        population = PopulationFactory.getTotal(100000);
        populations.add(population);
    }

    @Test
    public void aCreate() {
        Population popService = populationService.create(PopulationFactory.getTotal(200000));
        System.out.println("Created population: " + popService.getTotal());
        Assert.assertNotNull(popService);
        populations.add(popService);
    }

    @Test
    public void cUpdate() {
        int newTotal = 250000;
        Population updated = populationService.update(new Population.Builder().copy(population).population(newTotal).build());
        System.out.println("In update, updated = " + updated);
        populations.add(updated);
        Assert.assertEquals(updated.getId(), populationService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = populations.size();
        System.out.println("Before deleting object: " + population.getId());
        populations.remove(population.getId());
        System.out.println("After deleting object: " + population.getId());
        Assert.assertEquals(total, populations.size() - 1);
    }

    @Test
    public void bRead()
    {
        Population readPopulation = populationService.read(population.getId());
        System.out.println("readPopulation id: " + readPopulation.getId());
        System.out.println("populationService id: " + populationService.read(readPopulation.getId()));
        Assert.assertEquals(readPopulation.getId(), populationService.read(readPopulation.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Population> populationList = populationService.getAll();
        System.out.println("Display all objects: " + populationList.toString());
        Assert.assertEquals(populationList.size(), populationService.getAll().size());
    }

}