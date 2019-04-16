package com.djohannes.ac.za.factory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import com.djohannes.ac.za.domain.Religion;

public class ReligionFactoryTest {

    @Test
    public void getReligion()
    {
        Religion religion = ReligionFactory.getReligion("Christian");
        Assert.assertEquals("Christian", religion.getFaith());
    }
}