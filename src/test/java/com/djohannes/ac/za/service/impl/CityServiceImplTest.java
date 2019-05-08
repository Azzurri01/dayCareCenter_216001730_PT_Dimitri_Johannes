package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.CityRepository;
import com.djohannes.ac.za.repository.impl.CityRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class CityServiceImplTest {

    private CityRepository repository;
    private City city;

    Name name = NameFactory.getName("Cape Town");
    Population population = PopulationFactory.getTotal(2000000);

    private City getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = CityRepositoryImpl.getRepository();
        this.city = CityFactory.getCity(name, population);
    }

    @Test
    public void aCreate()
    {
        City created = this.repository.create(this.city);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.city);
    }

    @Test
    public void bUpdate()
    {
        String newCityId = "123";
        City updated = new City.Builder().copy(getSaved()).id(newCityId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCityId, updated.getId());
    }

    @Test
    public void cDelete()
    {
        City saved = getSaved();
        this.repository.delete(saved.getId());
        eGetAll();
    }

    @Test
    public void dRead()
    {
        City saved = getSaved();
        City read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void eGetAll()
    {
        Set<City> cities = this.repository.getAll();
        System.out.println("In getall, all = " + cities);
    }
}