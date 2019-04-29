package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Address;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressFactoryTest {

    @Test
    public void getAddress()
    {
        Address address = AddressFactory.getAddress("14", "Sentinel Road", "Heideveld");
        Assert.assertEquals("14", address.getNo());
        Assert.assertEquals("Sentinel Road", address.getStreet());
        Assert.assertEquals("Heideveld", address.getSuburb());
    }
}