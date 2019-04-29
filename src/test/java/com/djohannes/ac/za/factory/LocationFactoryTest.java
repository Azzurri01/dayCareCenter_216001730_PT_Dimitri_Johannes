package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Location;
import org.junit.Assert;
import org.junit.Test;

public class LocationFactoryTest {

    @Test
    public void getLocation()
    {
        Location location = LocationFactory.getLocation(25, "suburb");
        Assert.assertEquals(25, location.getlID());
        Assert.assertEquals("suburb", location.getType());
    }
}