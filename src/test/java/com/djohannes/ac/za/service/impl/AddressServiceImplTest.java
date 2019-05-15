package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.AddressRepository;
import com.djohannes.ac.za.repository.impl.AddressRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class AddressServiceImplTest {

    private AddressRepository repository;
    private Address address;

    Name name = NameFactory.getName("Heideveld");
    Population population = PopulationFactory.getTotal(100000);
    Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
    City city = CityFactory.getCity(name, population);
    Province province = ProvinceFactory.getProvince(name, population);

    private Address getSaved(){
        return this.repository.getAll().iterator().next();
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
        Address created = this.repository.create(this.address);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.address);
    }

    @Test
    public void cUpdate()
    {
        String newLocationId = "123";
        Address updated = new Address.Builder().copy(getSaved()).id(newLocationId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newLocationId, updated.getId());
    }

    @Test
    public void eDelete()
    {
        Address saved = getSaved();
        this.repository.delete(saved.getId());
        dGetAll();
    }

    @Test
    public void bRead()
    {
        Address saved = getSaved();
        Address read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void dGetAll()
    {
        Set<Address> addresses = this.repository.getAll();
        System.out.println("In getall, all = " + addresses);
    }
}