package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.DrawingService;
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
public class DrawingServiceImplTest {

    @Autowired
    @Qualifier("DrawingServiceImpl")
    private DrawingService drawingService;
    private Drawing drawing;
    private Set<Drawing> drawings = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        drawing = DrawingFactory.getDrawing("Green");
        drawings.add(drawing);
    }

    @Test
    public void aCreate() {
        Drawing draService = drawingService.create(DrawingFactory.getDrawing("Brown"));
        System.out.println("Created drawing: " + draService.getShapes());
        Assert.assertNotNull(draService);
        drawings.add(draService);
    }

    @Test
    public void cUpdate() {
        String newDrawing = "Blue";
        Drawing updated = drawingService.update(new Drawing.Builder().copy(drawing).drawing(newDrawing).build());
        System.out.println("In update, updated = " + updated);
        drawings.add(updated);
        Assert.assertEquals(updated.getId(), drawingService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = drawings.size();
        System.out.println("Before deleting object: " + drawing.getId());
        drawings.remove(drawing.getId());
        System.out.println("After deleting object: " + drawing.getId());
        Assert.assertEquals(total, drawings.size() - 1);
    }

    @Test
    public void bRead()
    {
        Drawing readDrawing = drawingService.read(drawing.getId());
        System.out.println("readDrawing id: " + readDrawing.getId());
        System.out.println("drawingService id: " + drawingService.read(readDrawing.getId()));
        Assert.assertEquals(readDrawing.getId(), drawingService.read(readDrawing.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Drawing> drawingList = drawingService.getAll();
        System.out.println("Display all objects: " + drawingList.toString());
        Assert.assertEquals(drawingList.size(), drawingService.getAll().size());
    }

}