package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Country;

public class CountryFactory
{
    public static Country getCountry(int id, String name)
    {
        return new Country.Builder()
                .getID(id)
                .getName(name)
                .build();
    }
}
