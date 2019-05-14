package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.domain.City;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.CityRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityRepositoryImplTest {

    private CityRepository repository;
    private City city;

    Name name = NameFactory.getName("Cape Town");
    Population population = PopulationFactory.getTotal(2000000);

    private City getSavedCity()
    {
        Set<City> savedCity = this.repository.getAll();
        return  savedCity.iterator().next();
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
        City createdCity = this.repository.create(this.city);
        System.out.println("Create method called: Created city = " + this.city);
        eGetAll();
        Assert.assertSame(createdCity, this.city);
    }

    @Test
    public void bRead()
    {
        City savedCity = getSavedCity();
        System.out.println("Read method call 1: Reading cityID = " + savedCity.getId());
        City readCity = this.repository.read(savedCity.getId());
        System.out.println("Read method call 2: Reading read = " + readCity);
        eGetAll();
        Assert.assertSame(savedCity, readCity);
    }

    @Test
    public void cUpdate()
    {
        Population population = PopulationFactory.getTotal(4000000);
        City newCity = new City.Builder().copy(getSavedCity()).population(population).build();
        System.out.println("In update, about_to_updated = " + newCity);
        City updated = this.repository.update(newCity);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newCity, updated);
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        City savedCity = getSavedCity();
        this.repository.delete(savedCity.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<City> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}
