package com.djohannes.ac.za.repository.impl;

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

    Name subName = NameFactory.getName("Heideveld");
    Name citName = NameFactory.getName("Cape Town");
    Name provName = NameFactory.getName("Western Province");
    Population subPopulation = PopulationFactory.getTotal(100000);
    Population citPopulation = PopulationFactory.getTotal(2000000);
    Population provPopulation = PopulationFactory.getTotal(30000000);
    Suburb suburb = SuburbFactory.getSuburb("7764", subName, subPopulation);
    City city = CityFactory.getCity(citName, citPopulation);
    Province province = ProvinceFactory.getProvince(provName, provPopulation);

    private Address getSavedLocation()
    {
        Set<Address> savedAddress = this.repository.getAll();
        return  savedAddress.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = AddressRepositoryImpl.getRepository();
        this.address = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);
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
        Address savedAddress = getSavedLocation();
        System.out.println("Read method call 1: Reading locationID = " + savedAddress.getId());
        Address readAddress = this.repository.read(savedAddress.getId());
        System.out.println("Read method call 2: Reading read = " + savedAddress.getId());
        eGetAll();
        Assert.assertSame(savedAddress, readAddress);
    }

    @Test
    public void cUpdate()
    {
        Suburb suburb = SuburbFactory.getSuburb("7764", subName, subPopulation);
        Address newAddress = new Address.Builder().copy(getSavedLocation()).suburb(suburb).build();
        System.out.println("In update, about_to_updated = " + newAddress);
        Address updated = this.repository.update(newAddress);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newAddress, updated);
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Address savedAddress = getSavedLocation();
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