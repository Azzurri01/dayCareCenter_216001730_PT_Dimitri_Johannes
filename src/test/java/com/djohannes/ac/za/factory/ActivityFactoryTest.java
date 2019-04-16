package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Activity;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActivityFactoryTest {

    @Test
    public void getActivity() {
        Activity activity = ActivityFactory.getActivity(7, "spelling");
        Assert.assertEquals(7, activity.getID());
        Assert.assertEquals("spelling", activity.getName());
    }
}