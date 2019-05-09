package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.ActivityRepository;
import com.djohannes.ac.za.repository.impl.ActivityRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class ActivityServiceImplTest {

    private ActivityRepository repository;
    private Activity activity;

    Grade grade = GradeFactory.getGrade("R");
    Evaluation evaluation = EvaluationFactory.getEvaluation(8);
    Alphabet alphabet = AlphabetFactory.getAlphabet("r", evaluation);
    Counting counting = CountingFactory.getCounting(5, evaluation);
    Colour colour = ColourFactory.getColour("pink", evaluation);
    Drawing drawing = DrawingFactory.getDrawing("rectangle", evaluation);
    Playtime playtime = PlaytimeFactory.getPlaytime("good", evaluation);

    private Activity getSaved(){
        return this.repository.getAll().iterator().next();
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
        Activity created = this.repository.create(this.activity);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.activity);
    }

    @Test
    public void bUpdate()
    {
        String newActivityId = "123";
        Activity updated = new Activity.Builder().copy(getSaved()).id(newActivityId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newActivityId, updated.getId());
    }

    @Test
    public void cDelete()
    {
        Activity saved = getSaved();
        this.repository.delete(saved.getId());
        eGetAll();
    }

    @Test
    public void dRead()
    {
        Activity saved = getSaved();
        Activity read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void eGetAll()
    {
        Set<Activity> activities = this.repository.getAll();
        System.out.println("In getall, all = " + activities);
    }
}