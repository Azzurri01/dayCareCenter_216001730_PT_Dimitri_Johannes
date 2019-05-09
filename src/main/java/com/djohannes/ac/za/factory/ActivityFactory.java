package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.util.Misc;

public class ActivityFactory
{
    public static Activity getActivity(Grade grade, Alphabet alphabet, Counting counting, Colour colour, Drawing drawing, Playtime playtime)
    {
        return new Activity.Builder()
                .id(Misc.generateId())
                .grade(grade)
                .alphabet(alphabet)
                .counting(counting)
                .colour(colour)
                .drawing(drawing)
                .playtime(playtime)
                .build();
    }
}
