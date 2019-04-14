package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Parent;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParentFactoryTest {

    @Test
    public void getParent()
    {
        Parent pFactory = ParentFactory.getParent("Fowzia", "Johannes", "0835133305");
        Assert.assertEquals("Fowzia", pFactory.getpName());
        Assert.assertEquals("Johannes", pFactory.getpSurname());
        Assert.assertEquals("0835133305", pFactory.getpPhone());
    }
}