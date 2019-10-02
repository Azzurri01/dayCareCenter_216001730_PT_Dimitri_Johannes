package com.djohannes.ac.za.factory.colour;

import com.djohannes.ac.za.domain.colour.Colour;
import com.djohannes.ac.za.util.Misc;

public class ColourFactory
{
    public static Colour getColour(String colour)
    {
        return new Colour.Builder()
                .id(Misc.generateId())
                .colour(colour)
                .build();
    }
}
