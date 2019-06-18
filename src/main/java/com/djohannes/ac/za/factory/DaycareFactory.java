package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.domain.Daycare;
import com.djohannes.ac.za.domain.Address;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.util.Misc;

public class DaycareFactory
{
    public static Daycare getDaycare(Name name, Address address, Contact contact)
    {
        return new Daycare.Builder()
                .id(Misc.generateId())
                .name(name)
                .location(address)
                .contact(contact)
                .build();
    }
}

