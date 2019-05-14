package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Evaluation;
import com.djohannes.ac.za.domain.Colour;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.ColourRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ColourRepositoryImplTest {

    private ColourRepository repository;
    private Colour colour;

    Evaluation evaluation = EvaluationFactory.getEvaluation(5);

    private Colour getSavedColour()
    {
        Set<Colour> savedColour = this.repository.getAll();
        return  savedColour.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = ColourRepositoryImpl.getRepository();
        this.colour = ColourFactory.getColour("yellow", evaluation);
    }

    @Test
    public void aCreate()
    {
        Colour createdColour = this.repository.create(this.colour);
        System.out.println("Create method called: Created colour = " + this.colour);
        eGetAll();
        Assert.assertSame(createdColour, this.colour);
    }

    @Test
    public void bRead()
    {
        Colour savedColour = getSavedColour();
        System.out.println("Read method call 1: Reading colourID = " + savedColour.getId());
        Colour readColour = this.repository.read(savedColour.getId());
        System.out.println("Read method call 2: Reading read = " + savedColour.getId());
        eGetAll();
        Assert.assertSame(savedColour, readColour);
    }

    @Test
    public void cUpdate()
    {
        Evaluation eval = EvaluationFactory.getEvaluation(8);
        Colour newEvaluation = new Colour.Builder().copy(getSavedColour()).evaluation(eval).build();
        System.out.println("In update, about_to_updated = " + newEvaluation);
        Colour updated = this.repository.update(newEvaluation);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newEvaluation, updated);
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Colour savedColour = getSavedColour();
        this.repository.delete(savedColour.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Colour> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}