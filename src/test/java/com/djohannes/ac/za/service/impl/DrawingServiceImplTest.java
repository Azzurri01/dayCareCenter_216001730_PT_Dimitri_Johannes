package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.DrawingRepository;
import com.djohannes.ac.za.repository.impl.DrawingRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class DrawingServiceImplTest {

    private DrawingRepository repository;
    private Drawing drawing;

    Evaluation evaluation = EvaluationFactory.getEvaluation(5);

    private Drawing getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = DrawingRepositoryImpl.getRepository();
        this.drawing = DrawingFactory.getDrawing("circle", evaluation);
    }

    @Test
    public void aCreate()
    {
        Drawing created = this.repository.create(this.drawing);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.drawing);
    }

    @Test
    public void cUpdate()
    {
        String newDrawingId = "123";
        Drawing updated = new Drawing.Builder().copy(getSaved()).id(newDrawingId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newDrawingId, updated.getId());
    }

    @Test
    public void cDelete()
    {
        Drawing saved = getSaved();
        this.repository.delete(saved.getId());
        eGetAll();
    }

    @Test
    public void bRead()
    {
        Drawing saved = getSaved();
        Drawing read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void eGetAll()
    {
        Set<Drawing> shapes = this.repository.getAll();
        System.out.println("In getall, all = " + shapes);
    }
}