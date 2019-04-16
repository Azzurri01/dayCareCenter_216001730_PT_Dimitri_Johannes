package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Deworm;
import org.junit.Assert;
import org.junit.Test;
import com.djohannes.ac.za.domain.Deworm;

public class DewormFactoryTest {

    @Test
    public void getMedical()
    {
        Deworm deworm = DewormFactory.getInjection("yes");
        Assert.assertEquals("yes", deworm.getDeworming());
    }
}