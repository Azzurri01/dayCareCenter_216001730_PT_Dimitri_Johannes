package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.ActivityService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ActivityServiceImplTest {

    @Autowired
    @Qualifier("ActivityServiceImpl")
    private ActivityService activityService;
    private Activity activity;
    private Set<Activity> activities = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        Grade grade = GradeFactory.getGrade("R");
        Alphabet alphabet = AlphabetFactory.getAlphabet("r");
        Counting counting = CountingFactory.getCounting(5);
        Colour colour = ColourFactory.getColour("pink");
        Drawing drawing = DrawingFactory.getDrawing("rectangle");
        Playtime playtime = PlaytimeFactory.getPlaytime("good");

        Activity activity = ActivityFactory.getActivity(grade, alphabet, counting, colour, drawing, playtime);
        activities.add(activity);
    }

    @Test
    public void aCreate() {
        Grade grade1 = GradeFactory.getGrade("R");
        Alphabet alphabet1 = AlphabetFactory.getAlphabet("r");
        Counting counting1 = CountingFactory.getCounting(5);
        Colour colour1 = ColourFactory.getColour("pink");
        Drawing drawing1 = DrawingFactory.getDrawing("rectangle");
        Playtime playtime1 = PlaytimeFactory.getPlaytime("good");

        Activity actService = activityService.create(ActivityFactory.getActivity(grade1, alphabet1, counting1, colour1, drawing1, playtime1));
        System.out.println("Created activity: " + actService.getAlphabet());
        Assert.assertNotNull(actService);
        activities.add(actService);
    }

    @Test
    public void cUpdate() {
        Counting counting = CountingFactory.getCounting(10);
        Activity updated = activityService.update(new Activity.Builder().copy(activity).counting(counting).build());
        System.out.println("In update, updated = " + updated);
        activities.add(updated);
        Assert.assertEquals(updated.getId(), activityService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = activities.size();
        System.out.println("Before deleting object: " + activity.getId());
        activities.remove(activity.getId());
        System.out.println("After deleting object: " + activity.getId());
        Assert.assertEquals(total, activities.size() - 1);
    }

    @Test
    public void bRead()
    {
        Activity readActivity = activityService.read(activity.getId());
        System.out.println("readActivity id: " + readActivity.getId());
        System.out.println("activityService id: " + activityService.read(readActivity.getId()));
        Assert.assertEquals(readActivity.getId(), activityService.read(readActivity.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Activity> activityList = activityService.getAll();
        System.out.println("Display all objects: " + activityList.toString());
        Assert.assertEquals(activityList.size(), activityService.getAll().size());
    }

}