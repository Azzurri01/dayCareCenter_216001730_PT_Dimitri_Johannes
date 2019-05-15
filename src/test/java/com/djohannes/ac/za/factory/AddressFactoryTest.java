package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.domain.Name;
import org.junit.Assert;
import org.junit.Test;

public class AddressFactoryTest {

    @Test
    public void getLocation()
    {
        Name name = NameFactory.getName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
        City city = CityFactory.getCity(name, population);
        Province province = ProvinceFactory.getProvince(name, population);
        Address address = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);

        Assert.assertNotNull(address.getId());
        Assert.assertEquals(address.getId(), address.getId());
        Assert.assertEquals(address.getNo(), address.getNo());
        Assert.assertEquals(address.getStreet(), address.getStreet());

        Assert.assertEquals(suburb.getId(), address.getSuburb().getId());
        Assert.assertEquals(suburb.getName().getname(), address.getSuburb().getName().getname());
        Assert.assertEquals(suburb.getPopulation(), address.getSuburb().getPopulation());
        Assert.assertEquals(suburb.getAreaCode(), address.getSuburb().getAreaCode());

        Assert.assertEquals(city.getId(), address.getCity().getId());
        Assert.assertEquals(city.getName().getname(), address.getCity().getName().getname());
        Assert.assertEquals(city.getPopulation(), address.getCity().getPopulation());

        Assert.assertEquals(province.getId(), address.getProvince().getId());
        Assert.assertEquals(province.getName().getname(), address.getProvince().getName().getname());
        Assert.assertEquals(province.getPopulation(), address.getProvince().getPopulation());
    }
}