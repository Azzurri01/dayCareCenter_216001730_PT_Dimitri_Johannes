package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.City;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.util.Misc;

public class CityFactory
{
    public static City getCity(Name name, Population population)
    {
        return new City.Builder()
                .id(Misc.generateId())
                .name(name)
                .population(population)
                .build();
    }
}
