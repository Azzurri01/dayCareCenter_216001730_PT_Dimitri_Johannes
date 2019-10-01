package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.AlphabetService;
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
public class AlphabetServiceImplTest {

    @Autowired
    @Qualifier("AlphabetServiceImpl")
    private AlphabetService alphabetService;
    private Alphabet alphabet;
    private Set<Alphabet> alphabets = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        alphabet = AlphabetFactory.getAlphabet("A");
        alphabets.add(alphabet);
    }

    @Test
    public void aCreate() {
        Alphabet alpService = alphabetService.create(AlphabetFactory.getAlphabet("B"));
        System.out.println("Created letter: " + alpService.getLetter());
        Assert.assertNotNull(alpService);
        alphabets.add(alpService);
    }

    @Test
    public void cUpdate() {
        String newAlphabet = "C";
        Alphabet updated = alphabetService.update(new Alphabet.Builder().copy(alphabet).letter(newAlphabet).build());
        System.out.println("In update, updated = " + updated);
        alphabets.add(updated);
        Assert.assertEquals(updated.getId(), alphabetService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = alphabets.size();
        System.out.println("Before deleting object: " + alphabet.getId());
        alphabets.remove(alphabet.getId());
        System.out.println("After deleting object: " + alphabet.getId());
        Assert.assertEquals(total, alphabets.size() - 1);
    }

    @Test
    public void bRead()
    {
        Alphabet readAlphabet = alphabetService.read(alphabet.getId());
        System.out.println("readAlphabet id: " + readAlphabet.getId());
        System.out.println("alphabetService id: " + alphabetService.read(readAlphabet.getId()));
        Assert.assertEquals(readAlphabet.getId(), alphabetService.read(readAlphabet.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Alphabet> alphabetList = alphabetService.getAll();
        System.out.println("Display all objects: " + alphabetList.toString());
        Assert.assertEquals(alphabetList.size(), alphabetService.getAll().size());
    }

}