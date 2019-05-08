package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.domain.Daycare;
import com.djohannes.ac.za.domain.Location;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.util.Misc;

public class DaycareFactory
{
    public static Daycare getDaycare(Name name, Location location, Contact contact)
    {
        return new Daycare.Builder()
                .id(Misc.generateId())
                .name(name)
                .location(location)
                .contact(contact)
                .build();
    }
}

