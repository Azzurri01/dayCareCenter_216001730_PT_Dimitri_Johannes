package com.djohannes.ac.za.factory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import com.djohannes.ac.za.domain.Bathroom;

public class BathroomFactoryTest {

    @Test
    public void getBathroomBreak()
    {
        Bathroom bathroom = BathroomFactory.getBathroomBreak("10:30am");
        Assert.assertEquals("10:30am", bathroom.getBathroomBreak());
    }
}