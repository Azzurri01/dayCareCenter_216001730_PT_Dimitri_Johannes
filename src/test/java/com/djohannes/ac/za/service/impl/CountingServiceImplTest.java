package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.CountingRepository;
import com.djohannes.ac.za.repository.impl.CountingRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class CountingServiceImplTest {

    private CountingRepository repository;
    private Counting counting;

    Evaluation evaluation = EvaluationFactory.getEvaluation(5);

    private Counting getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = CountingRepositoryImpl.getRepository();
        this.counting = CountingFactory.getCounting(3, evaluation);
    }

    @Test
    public void aCreate()
    {
        Counting created = this.repository.create(this.counting);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.counting);
    }

    @Test
    public void cUpdate()
    {
        String newCountingId = "123";
        Counting updated = new Counting.Builder().copy(getSaved()).id(newCountingId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCountingId, updated.getId());
    }

    @Test
    public void eDelete()
    {
        Counting saved = getSaved();
        this.repository.delete(saved.getId());
        dGetAll();
    }

    @Test
    public void bRead()
    {
        Counting saved = getSaved();
        Counting read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void dGetAll()
    {
        Set<Counting> numbers = this.repository.getAll();
        System.out.println("In getall, all = " + numbers);
    }
}