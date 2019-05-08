package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.domain.Name;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationFactoryTest {

    @Test
    public void getLocation()
    {
        Name name = NameFactory.getName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        Address address = AddressFactory.getAddress("14", "Sentinel Road");
        Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
        City city = CityFactory.getCity(name, population);
        Province province = ProvinceFactory.getProvince("456", name, population);
        Location location = LocationFactory.getLocation("123", address, suburb, city, province);
    }
}