package com.djohannes.ac.za.factory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import com.djohannes.ac.za.domain.City;

public class CityFactoryTest {

    @Test
    public void getCity()
    {
        City city = new CityFactory().getCity(3,"Cape Town");
        Assert.assertEquals(3, city.getID());
        Assert.assertEquals("Cape Town", city.getName());
    }
}