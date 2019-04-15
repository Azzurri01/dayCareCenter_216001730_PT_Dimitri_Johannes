package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Medical;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicalFactoryTest {

    @Test
    public void getMedical()
    {
        Medical medical = MedicalFactory.getMedical("cat", "6 month", "polio", "25 Jan 2019", "yes");
        Assert.assertEquals("cat", medical.getAllergies());
        Assert.assertEquals("6 month", medical.getInjection());
        Assert.assertEquals("polio", medical.getDrop());
        Assert.assertEquals("25 Jan 2019", medical.getDate());
        Assert.assertEquals("yes", medical.getDeworming());
    }
}