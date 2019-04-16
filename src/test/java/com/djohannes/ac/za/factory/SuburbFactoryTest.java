package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Suburb;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuburbFactoryTest {

    @Test
    public void getSuburb()
    {
        Suburb suburb = SuburbFactory.getSuburb(5, "Heideveld");
        Assert.assertEquals(5, suburb.getID());
        Assert.assertEquals("Heideveld", suburb.getName());
    }
}