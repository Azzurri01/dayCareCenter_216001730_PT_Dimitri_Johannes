package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Parent;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.ParentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParentRepositoryImplTest {

    private ParentRepository repository;
    private Parent parent;

    Name name = NameFactory.getName("Dimitri", "Johannes");
    Contact contact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");

    private Parent getSavedParent()
    {
        Set<Parent> savedParent = this.repository.getAll();
        return  savedParent.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = ParentRepositoryImpl.getRepository();
        this.parent = ParentFactory.getParent(name, contact);
    }

    @Test
    public void aCreate()
    {
        Parent createdParent = this.repository.create(this.parent);
        System.out.println("Create method called: Created parent = " + this.parent);
        eGetAll();
        Assert.assertSame(createdParent, this.parent);
    }

    @Test
    public void bRead()
    {
        Parent savedParent = getSavedParent();
        System.out.println("Read method call 1: Reading parentID = " + savedParent.getId());
        Parent readParent = this.repository.read(savedParent.getId());
        System.out.println("Read method call 2: Reading read = " + savedParent.getId());
        eGetAll();
        Assert.assertSame(savedParent, readParent);
    }

    @Test
    public void cUpdate()
    {
        String newId = "112";
        Parent streetNo = new Parent.Builder().copy(getSavedParent()).id(newId).build();
        System.out.println("In update, about_to_updated = " + parent);
        Parent updated = this.repository.update(parent);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId().toString());;
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Parent savedParent = getSavedParent();
        this.repository.delete(savedParent.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Parent> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}