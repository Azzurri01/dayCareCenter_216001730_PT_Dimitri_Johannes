package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.ParentService;
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
public class ParentServiceImplTest {

    @Autowired
    @Qualifier("ParentServiceImpl")
    private ParentService parentService;
    private Parent parent;
    private Set<Parent> parents = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        Name pName = NameFactory.getName("Dimitri", "Johannes");
        Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
        parent = ParentFactory.getParent(pName, pContact);
        parents.add(parent);
    }

    @Test
    public void aCreate() {
        Name pName1 = NameFactory.getName("Naqeeb", "Johannes");
        Contact pContact1 = ContactFactory.getContact("123", "naqeeb.johannes@gmail.com");
        Parent parService = parentService.create(ParentFactory.getParent(pName1,pContact1));
        System.out.println("Created parent: " +  parService.getName() + " " + parService.getContact());
        Assert.assertNotNull(parService);
        parents.add( parService);
    }

    @Test
    public void cUpdate() {
        Contact newContact = ContactFactory.getContact("456", "nuriyat.johannes@gmail.com");
        Parent updated = parentService.update(new Parent.Builder().copy(parent).Contact(newContact).build());
        System.out.println("In update, updated = " + updated);
        parents.add(updated);
        Assert.assertEquals(updated.getId(), parentService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = parents.size();
        System.out.println("Before deleting object: " + parent.getId());
        parents.remove(parent.getId());
        System.out.println("After deleting object: " + parent.getId());
        Assert.assertEquals(total, parents.size() - 1);
    }

    @Test
    public void bRead()
    {
        Parent readParent = parentService.read(parent.getId());
        System.out.println("readParent id: " + readParent.getId());
        System.out.println("parentService id: " + parentService.read(readParent.getId()));
        Assert.assertEquals(readParent.getId(), parentService.read(readParent.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Parent> parentList = parentService.getAll();
        System.out.println("Display all objects: " + parentList.toString());
        Assert.assertEquals(parentList.size(), parentService.getAll().size());
    }

}