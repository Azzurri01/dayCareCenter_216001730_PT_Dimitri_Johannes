package com.djohannes.ac.za.factory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import com.djohannes.ac.za.domain.Person;

public class PersonFactoryTest {

    @Test
    public void getPerson()
    {
        Person person = PersonFactory.getPerson("Dimitri", "Johannes", "0824512653", 'm', 34);
        Assert.assertEquals("Dimitri", person.getName());
        Assert.assertEquals("Johannes", person.getSurname());
        Assert.assertEquals("0824512653", person.getPhone());
        Assert.assertEquals("m", person.getGender());
        Assert.assertEquals(34, person.getAge());
    }
}