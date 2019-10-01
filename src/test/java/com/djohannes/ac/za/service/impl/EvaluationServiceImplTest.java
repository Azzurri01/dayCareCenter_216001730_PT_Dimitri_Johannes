package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.EvaluationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EvaluationServiceImplTest {

    @Autowired
    @Qualifier("EvaluationServiceImpl")
    private EvaluationService evaluationService;
    private Evaluation evaluation;
    private Set<Evaluation> evaluations = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        evaluation = EvaluationFactory.getEvaluation(6);
        evaluations.add(evaluation);
    }

    @Test
    public void aCreate() {
        Evaluation evaService = evaluationService.create(EvaluationFactory.getEvaluation(8));
        System.out.println("Created evaluation: " + evaService.getRating());
        Assert.assertNotNull(evaService);
        evaluations.add(evaService);
    }

    @Test
    public void cUpdate() {
        int newEvaluation = 10;
        Evaluation updated = evaluationService.update(new Evaluation.Builder().copy(evaluation).rating(newEvaluation).build());
        System.out.println("In update, updated = " + updated);
        evaluations.add(updated);
        Assert.assertEquals(updated.getId(), evaluationService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = evaluations.size();
        System.out.println("Before deleting object: " + evaluation.getId());
        evaluations.remove(evaluation.getId());
        System.out.println("After deleting object: " + evaluation.getId());
        Assert.assertEquals(total, evaluations.size() - 1);
    }

    @Test
    public void bRead()
    {
        Evaluation readEvaluation = evaluationService.read(evaluation.getId());
        System.out.println("readEvaluation id: " + readEvaluation.getId());
        System.out.println("evaluationService id: " + evaluationService.read(readEvaluation.getId()));
        Assert.assertEquals(readEvaluation.getId(), evaluationService.read(readEvaluation.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Evaluation> evaluationList = evaluationService.getAll();
        System.out.println("Display all objects: " + evaluationList.toString());
        Assert.assertEquals(evaluationList.size(), evaluationService.getAll().size());
    }

}