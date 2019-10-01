package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Colour;
import com.djohannes.ac.za.domain.Evaluation;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColourFactoryTest {

    @Test
    public void getColour()
    {
        Colour colour = ColourFactory.getColour("green");
        Assert.assertEquals("green", colour.getColour());
    }
}