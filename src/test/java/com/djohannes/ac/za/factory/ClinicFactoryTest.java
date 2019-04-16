package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Suburb;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import com.djohannes.ac.za.domain.Clinic;

public class ClinicFactoryTest {

    @Test
    public void getClinic()
    {
        Clinic clinic = ClinicFactory.getClinic(5, "Heideveld clinic");
        Assert.assertEquals(5, clinic.getID());
        Assert.assertEquals("Heideveld clinic", clinic.getName());
    }
}