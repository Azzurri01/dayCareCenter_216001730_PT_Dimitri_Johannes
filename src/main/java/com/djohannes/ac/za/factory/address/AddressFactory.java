package com.djohannes.ac.za.factory.address;

import com.djohannes.ac.za.domain.address.Address;
import com.djohannes.ac.za.util.Misc;

public class AddressFactory
{
    public static Address getAddress(int no, String str, String sub, String cty, String country)
    {
        return new Address.Builder()
                .id(Misc.generateId())
                .number(no)
                .getStreet(str)
                .getSuburb(sub)
                .getCity(cty)
                .getCountry(country)
                .build();
    }
}

