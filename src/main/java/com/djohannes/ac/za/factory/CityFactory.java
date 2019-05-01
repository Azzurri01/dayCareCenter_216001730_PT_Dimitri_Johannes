package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.City;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.domain.Name;

public class CityFactory
{
    public static City getCity(String id, Name name, Population population)
    {
        return new City.Builder()
                .id(id)
                .name(name)
                .population(population)
                .build();
    }
}
