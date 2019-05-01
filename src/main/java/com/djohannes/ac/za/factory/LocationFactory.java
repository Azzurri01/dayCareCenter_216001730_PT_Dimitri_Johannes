package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.*;

public class LocationFactory
{
    public static Location getLocation(String id, Address address, Suburb suburb, City city, Province province)
    {
        return new Location.Builder()
                .id(id)
                .address(address)
                .suburb(suburb)
                .city(city)
                .province(province)
                .build();
    }
}
