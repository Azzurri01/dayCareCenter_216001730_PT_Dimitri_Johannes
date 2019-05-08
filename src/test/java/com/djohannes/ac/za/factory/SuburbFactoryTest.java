package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.domain.Suburb;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuburbFactoryTest {

    @Test
    public void getSuburb()
    {
        Name name = NameFactory.getName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        Suburb suburb = SuburbFactory.getSuburb( "7764", name, population);
        Assert.assertEquals("12345", suburb.getId());
        Assert.assertEquals("7764", suburb.getAreaCode());
        Assert.assertEquals("Heideveld", name.getname());
        Assert.assertEquals(100000, population.getTotal());
    }
}