package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Province;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.domain.Name;
import org.junit.Assert;
import org.junit.Test;

public class ProvinceFactoryTest {

    @Test
    public void getProvince()
    {
        Name name = NameFactory.schoolName("Western Province");
        Population population = PopulationFactory.getTotal(10000000);
        Province province = ProvinceFactory.getProvince(name, population);
        Assert.assertNotNull(province.getId());
        Assert.assertEquals(name.getname(), province.getName().getname());
        Assert.assertEquals(population.getTotal(), province.getPopulation().getTotal());
    }
}