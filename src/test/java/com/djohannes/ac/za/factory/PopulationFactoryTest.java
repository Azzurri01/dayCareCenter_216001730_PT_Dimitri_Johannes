package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Population;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PopulationFactoryTest {

    @Test
    public void getTotal()
    {
        Population population = PopulationFactory.getTotal(1000000);
        Assert.assertNotNull(population.getId());
        Assert.assertEquals(1000000, population.getTotal());
    }
}