package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.LocationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocationRepositoryImplTest {

    private LocationRepository repository;
    private Location location;

    Name name = NameFactory.getName("Heideveld");
    Population population = PopulationFactory.getTotal(100000);
    Address address = AddressFactory.getAddress("14", "Sentinel Road");
    Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
    City city = CityFactory.getCity(name, population);
    Province province = ProvinceFactory.getProvince(name, population);

    private Location getSavedLocation()
    {
        Set<Location> savedLocation = this.repository.getAll();
        return  savedLocation.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = LocationRepositoryImpl.getRepository();
        this.location = LocationFactory.getLocation(address, suburb, city, province);
    }

    @Test
    public void aCreate()
    {
        Location createdLocation = this.repository.create(this.location);
        System.out.println("Create method called: Created location = " + this.location);
        eGetAll();
        Assert.assertSame(createdLocation, this.location);
    }

    @Test
    public void bRead()
    {
        Location savedLocation = getSavedLocation();
        System.out.println("Read method call 1: Reading locationID = " + savedLocation.getId());
        Location readLocation = this.repository.read(savedLocation.getId());
        System.out.println("Read method call 2: Reading read = " + savedLocation.getId());
        eGetAll();
        Assert.assertSame(savedLocation, readLocation);
    }

    @Test
    public void cUpdate()
    {
        String newId = "112";
        Location streetNo = new Location.Builder().copy(getSavedLocation()).id(newId).build();
        System.out.println("In update, about_to_updated = " + location);
        Location updated = this.repository.update(location);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId().toString());;
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Location savedLocation = getSavedLocation();
        this.repository.delete(savedLocation.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Location> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}