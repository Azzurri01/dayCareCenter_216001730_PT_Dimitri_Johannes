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
        Assert.assertEquals("123", province.getId());
        Assert.assertEquals("Western Province", name.getname());
        Assert.assertEquals(10000000, population.getTotal());
    }
}