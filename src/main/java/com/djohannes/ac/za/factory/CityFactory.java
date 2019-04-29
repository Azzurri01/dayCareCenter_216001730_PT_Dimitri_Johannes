package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.City;

public class CityFactory
{
    public static City getCity(String id, String name)
    {
        return new City.Builder()
                .getID(id)
                .getName(name)
                .build();
    }
}
