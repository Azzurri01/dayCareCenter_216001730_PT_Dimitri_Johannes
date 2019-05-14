package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Evaluation;
import com.djohannes.ac.za.domain.Counting;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.CountingRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountingRepositoryImplTest {

    private CountingRepository repository;
    private Counting counting;

    Evaluation evaluation = EvaluationFactory.getEvaluation(5);

    private Counting getSavedCounting()
    {
        Set<Counting> savedCounting = this.repository.getAll();
        return  savedCounting.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = CountingRepositoryImpl.getRepository();
        this.counting = CountingFactory.getCounting(5, evaluation);
    }

    @Test
    public void aCreate()
    {
        Counting createdCounting = this.repository.create(this.counting);
        System.out.println("Create method called: Created counting = " + this.counting);
        eGetAll();
        Assert.assertSame(createdCounting, this.counting);
    }

    @Test
    public void bRead()
    {
        Counting savedCounting = getSavedCounting();
        System.out.println("Read method call 1: Reading countingID = " + savedCounting.getId());
        Counting readCounting = this.repository.read(savedCounting.getId());
        System.out.println("Read method call 2: Reading read = " + savedCounting.getId());
        eGetAll();
        Assert.assertSame(savedCounting, readCounting);
    }

    @Test
    public void cUpdate()
    {
        Evaluation eval = EvaluationFactory.getEvaluation(8);
        Counting newEvaluation = new Counting.Builder().copy(getSavedCounting()).evaluation(eval).build();
        System.out.println("In update, about_to_updated = " + newEvaluation);
        Counting updated = this.repository.update(newEvaluation);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newEvaluation, updated);
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Counting savedCounting = getSavedCounting();
        this.repository.delete(savedCounting.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Counting> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}