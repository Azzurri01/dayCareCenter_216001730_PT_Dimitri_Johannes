package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Excursion;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcursionFactoryTest {

    @Test
    public void getExcursion()
    {
        Excursion excursion = ExcursionFactory.getExcursion("25 June 2019", "Greenpoint Park");
        Assert.assertEquals("25 June 2019", excursion.getDate());
        Assert.assertEquals("Greenpoint Park", excursion.getVenue());
    }
}