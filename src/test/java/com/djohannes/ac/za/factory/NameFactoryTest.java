package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Name;
import org.junit.Assert;
import org.junit.Test;

public class NameFactoryTest {

    @Test
    public void getName()
    {
        Name name = NameFactory.getName("Dimitri", "Johannes");
        Assert.assertEquals("Dimitri", name.getFirstName());
        Assert.assertEquals("Johannes", name.getLastName());
    }
}