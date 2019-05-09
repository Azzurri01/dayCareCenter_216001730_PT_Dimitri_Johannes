package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.domain.Name;
import org.junit.Assert;
import org.junit.Test;

public class LocationFactoryTest {

    @Test
    public void getLocation()
    {
        Name name = NameFactory.schoolName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        Address address = AddressFactory.getAddress("14", "Sentinel Road");
        Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
        City city = CityFactory.getCity(name, population);
        Province province = ProvinceFactory.getProvince(name, population);
        Location location = LocationFactory.getLocation(address, suburb, city, province);

        Assert.assertNotNull(location.getId());
        Assert.assertEquals(address.getId(), location.getAddress().getId());
        Assert.assertEquals(address.getNo(), location.getAddress().getNo());
        Assert.assertEquals(address.getStreet(), location.getAddress().getStreet());

        Assert.assertEquals(suburb.getId(), location.getSuburb().getId());
        Assert.assertEquals(suburb.getName().getname(), location.getSuburb().getName().getname());
        Assert.assertEquals(suburb.getPopulation(), location.getSuburb().getPopulation());
        Assert.assertEquals(suburb.getAreaCode(), location.getSuburb().getAreaCode());

        Assert.assertEquals(city.getId(), location.getCity().getId());
        Assert.assertEquals(city.getName().getname(), location.getCity().getName().getname());
        Assert.assertEquals(city.getPopulation(), location.getCity().getPopulation());

        Assert.assertEquals(province.getId(), location.getProvince().getId());
        Assert.assertEquals(province.getName().getname(), location.getProvince().getName().getname());
        Assert.assertEquals(province.getPopulation(), location.getProvince().getPopulation());
    }
}