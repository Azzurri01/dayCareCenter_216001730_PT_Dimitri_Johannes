package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.EvaluationRepository;
import com.djohannes.ac.za.repository.impl.EvaluationRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class EvaluationServiceImplTest {

    private EvaluationRepository repository;
    private Evaluation evaluation;

    private Evaluation getSaved(){
        return this.repository.getAll().iterator().next();
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
        Evaluation created = this.repository.create(this.evaluation);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.evaluation);
    }

    @Test
    public void bUpdate()
    {
        String newEvaluationId = "123";
        Evaluation updated = new Evaluation.Builder().copy(getSaved()).id(newEvaluationId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newEvaluationId, updated.getId());
    }

    @Test
    public void cDelete()
    {
        Evaluation saved = getSaved();
        this.repository.delete(saved.getId());
        eGetAll();
    }

    @Test
    public void dRead()
    {
        Evaluation saved = getSaved();
        Evaluation read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void eGetAll()
    {
        Set<Evaluation> evaluations = this.repository.getAll();
        System.out.println("In getall, all = " + evaluations);
    }
}