package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.City;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.domain.Name;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CityFactoryTest {

    @Test
    public void getCity()
    {
        Name name = NameFactory.getName("Cape Town");
        Population population = PopulationFactory.getTotal(2000000);
        City city = CityFactory.getCity(name, population);
        Assert.assertEquals("123", city.getId());
        Assert.assertEquals("Cape Town", name.getname());
        Assert.assertEquals(2000000, population.getTotal());
    }
}