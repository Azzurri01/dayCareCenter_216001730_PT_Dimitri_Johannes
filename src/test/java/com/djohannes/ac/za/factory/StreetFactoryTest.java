package com.djohannes.ac.za.factory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import com.djohannes.ac.za.domain.Street;

public class StreetFactoryTest {

    @Test
    public void getStreet()
    {
        Street street = StreetFactory.getStreet(14,"Sentinel road");
        Assert.assertEquals(14, street.getID());
        Assert.assertEquals("Sentinel road", street.getName());
    }
}