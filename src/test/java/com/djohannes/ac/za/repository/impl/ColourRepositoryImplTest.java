/*package com.djohannes.ac.za.repository.impl;

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

    private Colour getSavedColour()
    {
        Set<Colour> savedColour = this.repository.getAll();
        return  savedColour.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = ColourRepositoryImpl.getRepository();
        this.colour = ColourFactory.getColour("yellow");
    }

    @Test
    public void aCreate()
    {
        Colour createdColour = this.repository.create(this.colour);
        System.out.println("Create method called: Created colour = " + this.colour);
        dGetAll();
        Assert.assertSame(createdColour, this.colour);
    }

    @Test
    public void bRead()
    {
        Colour savedColour = getSavedColour();
        System.out.println("Read method call 1: Reading colourID = " + savedColour.getId());
        Colour readColour = this.repository.read(savedColour.getId());
        System.out.println("Read method call 2: Reading read = " + savedColour.getId());
        dGetAll();
        Assert.assertSame(savedColour, readColour);
    }

    @Test
    public void cUpdate()
    {
        String colour = "pink";
        Colour newColour = new Colour.Builder().copy(getSavedColour()).colour(colour).build();
        System.out.println("In update, about_to_updated = " + newColour);
        Colour updated = this.repository.update(newColour);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newColour, updated);
        dGetAll();
    }

    @Test
    public void eDelete()
    {
        Colour savedColour = getSavedColour();
        this.repository.delete(savedColour.getId());
        dGetAll();
    }

    @Test
    public void dGetAll()
    {
        Set<Colour> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}
*/