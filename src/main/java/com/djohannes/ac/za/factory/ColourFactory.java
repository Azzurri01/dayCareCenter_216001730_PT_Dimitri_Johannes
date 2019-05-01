package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Colour;
import com.djohannes.ac.za.domain.Evaluation;

public class ColourFactory
{
    public static Colour getColour(String colour, Evaluation evaluation)
    {
        return new Colour.Builder()
                .colour(colour)
                .evaluation(evaluation)
                .build();
    }
}
