package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Allergy;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AllergyFactoryTest {

    @Test
    public void getMedical()
    {
        Allergy allergy = AllergyFactory.getAllergy("cat");
        Assert.assertEquals("cat", allergy.getAllergy());
    }
}