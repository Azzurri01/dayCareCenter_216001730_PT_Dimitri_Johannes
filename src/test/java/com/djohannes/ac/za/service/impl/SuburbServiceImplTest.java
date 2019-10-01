package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.domain.Suburb;
import com.djohannes.ac.za.factory.NameFactory;
import com.djohannes.ac.za.factory.PopulationFactory;
import com.djohannes.ac.za.factory.SuburbFactory;
import com.djohannes.ac.za.service.SuburbService;
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
public class SuburbServiceImplTest {

    @Autowired
    @Qualifier("SuburbServiceImpl")
    private SuburbService suburbService;
    private Suburb suburb;
    private Set<Suburb> suburbs = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        Name name = NameFactory.getName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        suburb = SuburbFactory.getSuburb("7764", name, population);
        suburbs.add(suburb);
    }

    @Test
    public void aCreate() {
        Name name1 = NameFactory.getName("Hanover Park");
        Population population1 = PopulationFactory.getTotal(300000);
        Suburb subService = suburbService.create(SuburbFactory.getSuburb("7785",name1, population1));
        System.out.println("Created suburb: " + subService.getName());
        Assert.assertNotNull(subService);
        suburbs.add(subService);
    }

    @Test
    public void cUpdate() {
        Population population2 = PopulationFactory.getTotal(500000);
        Suburb updated = suburbService.update(new Suburb.Builder().copy(suburb).population(population2).build());
        System.out.println("In update, updated = " + updated);
        suburbs.add(updated);
        Assert.assertEquals(updated.getId(), suburbService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = suburbs.size();
        System.out.println("Before deleting object: " + suburb.getId());
        suburbs.remove(suburb.getId());
        System.out.println("After deleting object: " + suburb.getId());
        Assert.assertEquals(total, suburbs.size() - 1);
    }

    @Test
    public void bRead()
    {
        Suburb readSuburb = suburbService.read(suburb.getId());
        System.out.println("readSuburb id: " + readSuburb.getId());
        System.out.println("suburbService id: " + suburbService.read(readSuburb.getId()));
        Assert.assertEquals(readSuburb.getId(), suburbService.read(readSuburb.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Suburb> suburbList = suburbService.getAll();
        System.out.println("Display all objects: " + suburbList.toString());
        Assert.assertEquals(suburbList.size(), suburbService.getAll().size());
    }

}