package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.CityService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CityServiceImplTest {

    @Autowired
    @Qualifier("CityServiceImpl")
    private CityService cityService;
    private City city;
    private Set<City> cities = new HashSet<>();
    Name name = NameFactory.getName("Cape Town");
    Population population = PopulationFactory.getTotal(1000000);

    @Before
    public void setUp() throws Exception {
        city = CityFactory.getCity(name, population);
        cities.add(city);
    }

    @Test
    public void aCreate() {
        City citService = cityService.create(CityFactory.getCity(name, population));
        System.out.println("Created city: " + citService.getName());
        Assert.assertNotNull(citService);
        cities.add(citService);
    }

    @Test
    public void cUpdate() {
        String newCity = "Blue";
        City updated = cityService.update(new City.Builder().copy(city).name(name).build());
        System.out.println("In update, updated = " + updated);
        cities.add(updated);
        Assert.assertEquals(updated.getId(), cityService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = cities.size();
        System.out.println("Before deleting object: " + city.getId());
        cities.remove(city.getId());
        System.out.println("After deleting object: " + city.getId());
        Assert.assertEquals(total, cities.size() - 1);
    }

    @Test
    public void bRead()
    {
        City readCity = cityService.read(city.getId());
        System.out.println("readCity id: " + readCity.getId());
        System.out.println("cityService id: " + cityService.read(readCity.getId()));
        Assert.assertEquals(readCity.getId(), cityService.read(readCity.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<City> cityList = cityService.getAll();
        System.out.println("Display all objects: " + cityList.toString());
        Assert.assertEquals(cityList.size(), cityService.getAll().size());
    }

}