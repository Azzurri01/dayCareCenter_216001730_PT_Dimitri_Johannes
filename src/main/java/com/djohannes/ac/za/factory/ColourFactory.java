package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Colour;
import com.djohannes.ac.za.domain.Evaluation;
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
