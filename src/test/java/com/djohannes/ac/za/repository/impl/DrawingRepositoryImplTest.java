package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Evaluation;
import com.djohannes.ac.za.domain.Drawing;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.DrawingRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DrawingRepositoryImplTest {

    private DrawingRepository repository;
    private Drawing drawing;

    Evaluation evaluation = EvaluationFactory.getEvaluation(5);

    private Drawing getSavedDrawing()
    {
        Set<Drawing> savedDrawing = this.repository.getAll();
        return  savedDrawing.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = DrawingRepositoryImpl.getRepository();
        this.drawing = DrawingFactory.getDrawing("triangle", evaluation);
    }

    @Test
    public void aCreate()
    {
        Drawing createdDrawing = this.repository.create(this.drawing);
        System.out.println("Create method called: Created drawing = " + this.drawing);
        eGetAll();
        Assert.assertSame(createdDrawing, this.drawing);
    }

    @Test
    public void bRead()
    {
        Drawing savedDrawing = getSavedDrawing();
        System.out.println("Read method call 1: Reading drawingID = " + savedDrawing.getId());
        Drawing readDrawing = this.repository.read(savedDrawing.getId());
        System.out.println("Read method call 2: Reading read = " + savedDrawing.getId());
        eGetAll();
        Assert.assertSame(savedDrawing, readDrawing);
    }

    @Test
    public void cUpdate()
    {
        String newId = "112";
        Drawing streetNo = new Drawing.Builder().copy(getSavedDrawing()).id(newId).build();
        System.out.println("In update, about_to_updated = " + drawing);
        Drawing updated = this.repository.update(drawing);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId().toString());;
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Drawing savedDrawing = getSavedDrawing();
        this.repository.delete(savedDrawing.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Drawing> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}