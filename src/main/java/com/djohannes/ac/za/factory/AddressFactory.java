package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.util.Misc;

public class AddressFactory
{
    public static Address getAddress(String no, String str, Suburb suburb, City city, Province province)
    {
        return new Address.Builder()
                .id(Misc.generateId())
                .no(no)
                .street(str)
                .suburb(suburb)
                .city(city)
                .province(province)
                .build();
    }
}
