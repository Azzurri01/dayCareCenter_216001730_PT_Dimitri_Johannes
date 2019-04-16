package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Location;

public class LocationFactory
{
    public static Location getLocation(int id, String type)
    {
        return new Location.Builder()
                .getlID(id)
                .getType(type)
                .build();
    }
}
