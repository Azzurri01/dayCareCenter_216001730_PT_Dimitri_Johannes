package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.colour.Colour;
import com.djohannes.ac.za.factory.colour.ColourFactory;
import org.junit.Assert;
import org.junit.Test;

public class ColourFactoryTest {

    @Test
    public void getColour()
    {
        Colour colour = ColourFactory.getColour("green");
        Assert.assertEquals("green", colour.getColour());
    }
}