package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Country;

public class CountryFactory
{
    public static Country getCountry(String id, String name)
    {
        return new Country.Builder()
                .getCode(id)
                .getName(name)
                .build();
    }
}
