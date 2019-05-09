package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.domain.Suburb;
import org.junit.Assert;
import org.junit.Test;

public class SuburbFactoryTest {

    @Test
    public void getSuburb()
    {
        Name name = NameFactory.schoolName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        Suburb suburb = SuburbFactory.getSuburb( "7764", name, population);
        Assert.assertNotNull(suburb.getId());
        Assert.assertEquals("7764", suburb.getAreaCode());
        Assert.assertEquals(name.getname(), suburb.getName().getname());
        Assert.assertEquals(population.getTotal(), suburb.getPopulation().getTotal());
    }
}