package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Address;
import com.djohannes.ac.za.util.Misc;

public class AddressFactory
{
    public static Address getAddress(String no, String street)
    {
        return new Address.Builder()
                .id(Misc.generateId())
                .streetNo(no)
                .streetName(street)
                .build();
    }
}
