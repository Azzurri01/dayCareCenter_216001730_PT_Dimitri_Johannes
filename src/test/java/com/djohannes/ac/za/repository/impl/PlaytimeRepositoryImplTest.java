package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Evaluation;
import com.djohannes.ac.za.domain.Playtime;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.PlaytimeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlaytimeRepositoryImplTest {

    private PlaytimeRepository repository;
    private Playtime playtime;

    Evaluation evaluation = EvaluationFactory.getEvaluation(5);

    private Playtime getSavedPlaytime()
    {
        Set<Playtime> savedPlaytime = this.repository.getAll();
        return  savedPlaytime.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = PlaytimeRepositoryImpl.getRepository();
        this.playtime = PlaytimeFactory.getPlaytime("good", evaluation);
    }

    @Test
    public void aCreate()
    {
        Playtime createdPlaytime = this.repository.create(this.playtime);
        System.out.println("Create method called: Created playtime = " + this.playtime);
        eGetAll();
        Assert.assertSame(createdPlaytime, this.playtime);
    }

    @Test
    public void bRead()
    {
        Playtime savedPlaytime = getSavedPlaytime();
        System.out.println("Read method call 1: Reading playtimeID = " + savedPlaytime.getId());
        Playtime readPlaytime = this.repository.read(savedPlaytime.getId());
        System.out.println("Read method call 2: Reading read = " + savedPlaytime.getId());
        eGetAll();
        Assert.assertSame(savedPlaytime, readPlaytime);
    }

    @Test
    public void cUpdate()
    {
        String newId = "112";
        Playtime streetNo = new Playtime.Builder().copy(getSavedPlaytime()).id(newId).build();
        System.out.println("In update, about_to_updated = " + playtime);
        Playtime updated = this.repository.update(playtime);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId().toString());;
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Playtime savedPlaytime = getSavedPlaytime();
        this.repository.delete(savedPlaytime.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Playtime> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}