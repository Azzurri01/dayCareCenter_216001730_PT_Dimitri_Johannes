package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Evaluation;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.EvaluationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EvaluationRepositoryImplTest {

    private EvaluationRepository repository;
    private Evaluation evaluation;

    private Evaluation getSavedEvaluation()
    {
        Set<Evaluation> savedEvaluation = this.repository.getAll();
        return  savedEvaluation.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = EvaluationRepositoryImpl.getRepository();
        this.evaluation = EvaluationFactory.getEvaluation(9);
    }

    @Test
    public void aCreate()
    {
        Evaluation createdEvaluation = this.repository.create(this.evaluation);
        System.out.println("Create method called: Created evaluation = " + this.evaluation);
        eGetAll();
        Assert.assertSame(createdEvaluation, this.evaluation);
    }

    @Test
    public void bRead()
    {
        Evaluation savedEvaluation = getSavedEvaluation();
        System.out.println("Read method call 1: Reading evaluationID = " + savedEvaluation.getId());
        Evaluation readEvaluation = this.repository.read(savedEvaluation.getId());
        System.out.println("Read method call 2: Reading read = " + savedEvaluation.getId());
        eGetAll();
        Assert.assertSame(savedEvaluation, readEvaluation);
    }

    @Test
    public void cUpdate()
    {
        int mark = 7;
        Evaluation newRating = new Evaluation.Builder().copy(getSavedEvaluation()).rating(mark).build();
        System.out.println("In update, about_to_updated = " + newRating);
        Evaluation updated = this.repository.update(newRating);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newRating, updated);;
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Evaluation savedEvaluation = getSavedEvaluation();
        this.repository.delete(savedEvaluation.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Evaluation> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}