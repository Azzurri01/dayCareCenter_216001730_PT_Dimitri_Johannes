package com.djohannes.ac.za.factory.drawing;

import com.djohannes.ac.za.domain.drawing.Drawing;
import com.djohannes.ac.za.util.Misc;

public class DrawingFactory
{
    public static Drawing getDrawing(String drawing)
    {
        return new Drawing.Builder()
                .id(Misc.generateId())
                .drawing(drawing)
                .build();
    }
}
