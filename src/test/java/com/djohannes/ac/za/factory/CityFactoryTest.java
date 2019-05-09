package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.City;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.domain.Name;
import org.junit.Assert;
import org.junit.Test;

public class CityFactoryTest {

    @Test
    public void getCity()
    {
        Name name = NameFactory.schoolName("Cape Town");
        Population population = PopulationFactory.getTotal(2000000);
        City city = CityFactory.getCity(name, population);
        Assert.assertNotNull(city.getId());
        Assert.assertEquals(name.getname(), city.getName().getname());
        Assert.assertEquals(population.getTotal(), population.getTotal());
    }
}