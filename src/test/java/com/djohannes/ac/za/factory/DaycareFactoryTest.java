package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Daycare;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DaycareFactoryTest {

    @Test
    public void getDaycare() {
        Daycare daycare = DaycareFactory.getDaycare(5, "Mighty minds");
        Assert.assertEquals(5, daycare.getID());
        Assert.assertEquals("Mighty minds", daycare.getName());
    }
}