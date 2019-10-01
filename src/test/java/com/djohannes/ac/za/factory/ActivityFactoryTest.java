package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActivityFactoryTest {

    @Test
    public void getActivity()
    {
        Grade grade = GradeFactory.getGrade("R");
        Alphabet alphabet = AlphabetFactory.getAlphabet("r");
        Counting counting = CountingFactory.getCounting(5);
        Colour colour = ColourFactory.getColour("pink");
        Drawing drawing = DrawingFactory.getDrawing("rectangle");
        Playtime playtime = PlaytimeFactory.getPlaytime("good");

        Activity activity = ActivityFactory.getActivity(grade, alphabet, counting, colour, drawing, playtime);

        Assert.assertNotNull(activity.getId());
        Assert.assertEquals(grade.getGrade(), activity.getGrade().getGrade());
        Assert.assertEquals(alphabet.getLetter(), activity.getAlphabet().getLetter());
        Assert.assertEquals(counting.getNumber(), activity.getCounting().getNumber());
        Assert.assertEquals(colour.getColour(), activity.getColour().getColour());
        Assert.assertEquals(drawing.getShapes(), activity.getDrawing().getShapes());
        Assert.assertEquals(playtime.getBehaviour(), activity.getPlaytime().getBehaviour());
    }
}