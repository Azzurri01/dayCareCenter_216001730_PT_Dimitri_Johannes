package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Address;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.AddressRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressRepositoryImplTest {

    private AddressRepository repository;
    private Address address;

    private Address getSavedAddress()
    {
        Set<Address> savedAddress = this.repository.getAll();
        return  savedAddress.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = AddressRepositoryImpl.getRepository();
        this.address = AddressFactory.getAddress("14", "Sentinel Road");
    }

    @Test
    public void aCreate()
    {
        Address createdAddress = this.repository.create(this.address);
        System.out.println("Create method called: Created address = " + this.address);
        eGetAll();
        Assert.assertSame(createdAddress, this.address);
    }

    @Test
    public void bRead()
    {
        Address savedAddress = getSavedAddress();
        System.out.println("Read method call 1: Reading address = " + savedAddress);
        Address readAddress = this.repository.read(savedAddress.getId());
        System.out.println("Read method call 2: Reading read = " + readAddress);
        eGetAll();
        Assert.assertEquals(savedAddress, readAddress);
    }

    @Test
    public void cUpdate()
    {
        Address newAddress = new Address.Builder().copy(getSavedAddress()).build();
        System.out.println("In update, about_to_updated = " + newAddress);
        Address updated = this.repository.update(newAddress);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newAddress, updated);
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Address savedAddress = getSavedAddress();
        this.repository.delete(savedAddress.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Address> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}