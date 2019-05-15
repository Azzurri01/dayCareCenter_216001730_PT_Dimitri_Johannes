package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.PlaytimeRepository;
import com.djohannes.ac.za.repository.impl.PlaytimeRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class PlaytimeServiceImplTest {

    private PlaytimeRepository repository;
    private Playtime playtime;

    Evaluation evaluation = EvaluationFactory.getEvaluation(5);

    private Playtime getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = PlaytimeRepositoryImpl.getRepository();
        this.playtime = PlaytimeFactory.getPlaytime("excellent", evaluation);
    }

    @Test
    public void aCreate()
    {
        Playtime created = this.repository.create(this.playtime);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.playtime);
    }

    @Test
    public void cUpdate()
    {
        String newPlaytimeId = "123";
        Playtime updated = new Playtime.Builder().copy(getSaved()).id(newPlaytimeId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newPlaytimeId, updated.getId());
    }

    @Test
    public void eDelete()
    {
        Playtime saved = getSaved();
        this.repository.delete(saved.getId());
        dGetAll();
    }

    @Test
    public void bRead()
    {
        Playtime saved = getSaved();
        Playtime read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void dGetAll()
    {
        Set<Playtime> playtimes = this.repository.getAll();
        System.out.println("In getall, all = " + playtimes);
    }
}