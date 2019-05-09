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
    }
}