package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.util.Misc;

public class LocationFactory
{
    public static Location getLocation(Address address, Suburb suburb, City city, Province province)
    {
        return new Location.Builder()
                .id(Misc.generateId())
                .address(address)
                .suburb(suburb)
                .city(city)
                .province(province)
                .build();
    }
}
