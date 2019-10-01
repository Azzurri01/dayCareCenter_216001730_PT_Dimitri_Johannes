package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.NameService;
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
public class NameServiceImplTest {

    @Autowired
    @Qualifier("NameServiceImpl")
    private NameService nameService;
    private Name name;
    private Set<Name> names = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        name = NameFactory.getName("Green");
        names.add(name);
    }

    @Test
    public void aCreate() {
        Name namService = nameService.create(NameFactory.getName("Brown"));
        System.out.println("Created name: " + namService.getname());
        Assert.assertNotNull(namService);
        names.add(namService);
    }

    @Test
    public void cUpdate() {
        String newName = "Blue";
        Name updated = nameService.update(new Name.Builder().copy(name).name(newName).build());
        System.out.println("In update, updated = " + updated);
        names.add(updated);
        Assert.assertEquals(updated.getId(), nameService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = names.size();
        System.out.println("Before deleting object: " + name.getId());
        names.remove(name.getId());
        System.out.println("After deleting object: " + name.getId());
        Assert.assertEquals(total, names.size() - 1);
    }

    @Test
    public void bRead()
    {
        Name readName = nameService.read(name.getId());
        System.out.println("readName id: " + readName.getId());
        System.out.println("nameService id: " + nameService.read(readName.getId()));
        Assert.assertEquals(readName.getId(), nameService.read(readName.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Name> nameList = nameService.getAll();
        System.out.println("Display all objects: " + nameList.toString());
        Assert.assertEquals(nameList.size(), nameService.getAll().size());
    }

}