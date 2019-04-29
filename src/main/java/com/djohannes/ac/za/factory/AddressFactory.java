package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Address;

public class AddressFactory
{
    public static Address getAddress(String no, String street, String suburb)
    {
        return new Address.Builder()
                .streetNo(no)
                .streetName(street)
                .suburb(suburb)
                .build();
    }
}
