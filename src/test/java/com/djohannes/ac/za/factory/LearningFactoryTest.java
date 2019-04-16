package com.djohannes.ac.za.factory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import com.djohannes.ac.za.domain.Learning;

public class LearningFactoryTest {

    @Test
    public void getLearning()
    {
        Learning learning = LearningFactory.getLearning("Educational", 123);
        Assert.assertEquals("Educational", learning.getType());
        Assert.assertEquals(123, learning.getStuNo());
    }
}