package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Evaluation;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Population;
import com.djohannes.ac.za.domain.Alphabet;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.AlphabetRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlphabetRepositoryImplTest {

    private AlphabetRepository repository;
    private Alphabet alphabet;

    Evaluation evaluation = EvaluationFactory.getEvaluation(5);

    private Alphabet getSavedAlphabet()
    {
        Set<Alphabet> savedAlphabet = this.repository.getAll();
        return  savedAlphabet.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = AlphabetRepositoryImpl.getRepository();
        this.alphabet = AlphabetFactory.getAlphabet("d", evaluation);
    }

    @Test
    public void aCreate()
    {
        Alphabet createdAlphabet = this.repository.create(this.alphabet);
        System.out.println("Create method called: Created alphabet = " + this.alphabet);
        eGetAll();
        Assert.assertSame(createdAlphabet, this.alphabet);
    }

    @Test
    public void bRead()
    {
        Alphabet savedAlphabet = getSavedAlphabet();
        System.out.println("Read method call 1: Reading alphabetID = " + savedAlphabet.getId());
        Alphabet readAlphabet = this.repository.read(savedAlphabet.getId());
        System.out.println("Read method call 2: Reading read = " + savedAlphabet.getId());
        eGetAll();
        Assert.assertSame(savedAlphabet, readAlphabet);
    }

    @Test
    public void cUpdate()
    {
        Evaluation eval = EvaluationFactory.getEvaluation(8);
        Alphabet newEvaluation = new Alphabet.Builder().copy(getSavedAlphabet()).evaluation(eval).build();
        System.out.println("In update, about_to_updated = " +  newEvaluation);
        Alphabet updated = this.repository.update( newEvaluation);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame( newEvaluation, updated);
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Alphabet savedAlphabet = getSavedAlphabet();
        this.repository.delete(savedAlphabet.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Alphabet> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}