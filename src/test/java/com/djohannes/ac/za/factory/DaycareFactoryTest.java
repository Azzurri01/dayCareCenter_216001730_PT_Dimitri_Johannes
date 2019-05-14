package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Name;
import org.junit.Assert;
import org.junit.Test;

public class DaycareFactoryTest {

    @Test
    public void getName()
    {
        Name name = NameFactory.getName("Little rascals");
        Assert.assertEquals("Little rascals", name.getname());
    }
}