package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Country;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountryFactoryTest {

    @Test
    public void getCountry() {
        Country country = CountryFactory.getCountry(3, "South Africa");
        Assert.assertEquals(3, country.getID());
        Assert.assertEquals("South Africa", country.getName());
    }
}