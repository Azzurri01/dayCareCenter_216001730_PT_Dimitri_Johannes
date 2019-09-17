package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.ColourRepository;
import com.djohannes.ac.za.repository.impl.ColourRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class ColourServiceImplTest {

    private ColourRepository repository;
    private Colour colour;

    private Colour getSaved(){
        return this.repository.getAll().iterator().next();
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
        Colour created = this.repository.create(this.colour);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.colour);
    }

    @Test
    public void cUpdate()
    {
        String newColourId = "123";
        Colour updated = new Colour.Builder().copy(getSaved()).id(newColourId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newColourId, updated.getId());
    }

    @Test
    public void eDelete()
    {
        Colour saved = getSaved();
        this.repository.delete(saved.getId());
        dGetAll();
    }

    @Test
    public void bRead()
    {
        Colour saved = getSaved();
        Colour read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void dGetAll()
    {
        Set<Colour> colours = this.repository.getAll();
        System.out.println("In getall, all = " + colours);
    }
}