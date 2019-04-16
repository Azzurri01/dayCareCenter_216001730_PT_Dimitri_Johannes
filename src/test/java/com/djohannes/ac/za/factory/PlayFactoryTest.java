package com.djohannes.ac.za.factory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import com.djohannes.ac.za.domain.Play;

public class PlayFactoryTest {

    @Test
    public void getPlayTime()
    {
        Play play = PlayFactory.getPlayTime("10am");
        Assert.assertEquals("10am", play.getPlayTime());
    }
}