package com.djohannes.ac.za.factory;
import com.djohannes.ac.za.domain.Drawing;
import com.djohannes.ac.za.domain.Evaluation;

public class DrawingFactory
{
    public static Drawing getDrawing(String drawing, Evaluation evaluation)
    {
        return new Drawing.Builder()
                .drawing(drawing)
                .evaluation(evaluation)
                .build();
    }
}
