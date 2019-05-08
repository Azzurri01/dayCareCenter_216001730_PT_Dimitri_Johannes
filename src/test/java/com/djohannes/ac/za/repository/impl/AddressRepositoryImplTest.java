package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Name;
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
        System.out.println("Read method call 1: Reading addressID = " + savedAddress.getNo() + " " + savedAddress.getStreet());
        Address readAddress = this.repository.read(savedAddress.getNo() + " " + savedAddress.getStreet());
        System.out.println("Read method call 2: Reading read = " + savedAddress.getNo() + " " + savedAddress.getStreet());
        eGetAll();
        Assert.assertSame(savedAddress, readAddress);
    }

    @Test
    public void cUpdate()
    {
        String newno = "14";
        String newstr = "Sentinel Road";
        Address streetNo = new Address.Builder().copy(getSavedAddress()).streetNo(newno).build();
        Address streetName = new Address.Builder().copy(getSavedAddress()).streetName(newno).build();
        System.out.println("In update, about_to_updated = " + address);
        Address updated = this.repository.update(address);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newno, updated.getNo().toString());
        Assert.assertSame(newno, updated.getStreet().toString());
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Address savedAddress = getSavedAddress();
        this.repository.delete(savedAddress.getNo());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Address> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}