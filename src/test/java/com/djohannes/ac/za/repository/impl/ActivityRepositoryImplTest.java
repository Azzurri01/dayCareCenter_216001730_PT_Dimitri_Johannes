/*package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.ActivityRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ActivityRepositoryImplTest {

    private ActivityRepository repository;
    private Activity activity;

    Grade grade = GradeFactory.getGrade("R");
    Evaluation evaluation = EvaluationFactory.getEvaluation(8);
    Alphabet alphabet = AlphabetFactory.getAlphabet("r", evaluation);
    Counting counting = CountingFactory.getCounting(5, evaluation);
    Colour colour = ColourFactory.getColour("pink");
    Drawing drawing = DrawingFactory.getDrawing("rectangle", evaluation);
    Playtime playtime = PlaytimeFactory.getPlaytime("good", evaluation);

    private Activity getSavedActivity()
    {
        Set<Activity> savedActivity = this.repository.getAll();
        return  savedActivity.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = ActivityRepositoryImpl.getRepository();
        this.activity = ActivityFactory.getActivity(grade, alphabet, counting, colour, drawing, playtime);
    }

    @Test
    public void aCreate()
    {
        Activity createdActivity = this.repository.create(this.activity);
        System.out.println("Create method called: Created activity = " + this.activity);
        dGetAll();
        Assert.assertSame(createdActivity, this.activity);
    }

    @Test
    public void bRead()
    {
        Activity newActivity = getSavedActivity();
        System.out.println("Read method call 1: Reading activity = " +  newActivity);
        Activity readActivity = this.repository.read( newActivity.getId());
        System.out.println("Read method call 2: Reading read = " + readActivity);
        dGetAll();
        Assert.assertSame( newActivity, readActivity);
    }

    @Test
    public void cUpdate()
    {
        Grade newGrade = GradeFactory.getGrade("w");
        Activity updatedActivity = new Activity.Builder().copy(getSavedActivity()).grade(newGrade).build();
        System.out.println("In update, about_to_updated = " + updatedActivity);
        Activity updated = this.repository.update(updatedActivity);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newGrade, updated.getGrade());
        dGetAll();
    }

    @Test
    public void eDelete()
    {
        Activity savedActivity = getSavedActivity();
        this.repository.delete(savedActivity.getId());
        dGetAll();
    }

    @Test
    public void dGetAll()
    {
        Set<Activity> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}*/