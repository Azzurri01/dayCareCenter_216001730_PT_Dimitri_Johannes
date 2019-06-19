package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.util.Misc;

public class DrawingFactory
{
    public static Drawing getDrawing(String drawing, Evaluation evaluation)
    {
        return new Drawing.Builder()
                .id(Misc.generateId())
                .drawing(drawing)
                .evaluation(evaluation)
                .build();
    }
}
