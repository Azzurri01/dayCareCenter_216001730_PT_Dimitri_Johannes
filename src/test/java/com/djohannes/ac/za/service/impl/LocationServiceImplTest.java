package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.LocationRepository;
import com.djohannes.ac.za.repository.impl.LocationRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class LocationServiceImplTest {

    private LocationRepository repository;
    private Location location;

    Name name = NameFactory.schoolName("Heideveld");
    Population population = PopulationFactory.getTotal(100000);
    Address address = AddressFactory.getAddress("14", "Sentinel Road");
    Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
    City city = CityFactory.getCity(name, population);
    Province province = ProvinceFactory.getProvince(name, population);

    private Location getSaved(){
        return this.repository.getAll().iterator().next();
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
        Location created = this.repository.create(this.location);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.location);
    }

    @Test
    public void bUpdate()
    {
        String newLocationId = "123";
        Location updated = new Location.Builder().copy(getSaved()).id(newLocationId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newLocationId, updated.getId());
    }

    @Test
    public void cDelete()
    {
        Location saved = getSaved();
        this.repository.delete(saved.getId());
        eGetAll();
    }

    @Test
    public void dRead()
    {
        Location saved = getSaved();
        Location read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void eGetAll()
    {
        Set<Location> locations = this.repository.getAll();
        System.out.println("In getall, all = " + locations);
    }
}