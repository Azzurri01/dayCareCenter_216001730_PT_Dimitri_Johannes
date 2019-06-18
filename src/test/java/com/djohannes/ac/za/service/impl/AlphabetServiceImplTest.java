package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.AlphabetRepository;
import com.djohannes.ac.za.repository.impl.AlphabetRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class AlphabetServiceImplTest {

    private AlphabetRepository repository;
    private Alphabet alphabet;

    Evaluation evaluation = EvaluationFactory.getEvaluation(5);

    private Alphabet getSaved(){
        return this.repository.getAll().iterator().next();
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
        Alphabet created = this.repository.create(this.alphabet);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.alphabet);
    }

    @Test
    public void cUpdate()
    {
        String newAlphabetId = "123";
        Alphabet updated = new Alphabet.Builder().copy(getSaved()).id(newAlphabetId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newAlphabetId, updated.getId());
    }

    @Test
    public void eDelete()
    {
        Alphabet saved = getSaved();
        this.repository.delete(saved.getId());
        dGetAll();
    }

    @Test
    public void bRead()
    {
        Alphabet saved = getSaved();
        Alphabet read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void dGetAll()
    {
        Set<Alphabet> letters = this.repository.getAll();
        System.out.println("In getall, all = " + letters);
    }
}