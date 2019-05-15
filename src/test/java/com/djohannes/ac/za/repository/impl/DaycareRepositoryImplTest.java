package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.DaycareRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DaycareRepositoryImplTest {

    private DaycareRepository repository;
    private Daycare daycare;

    Name name = NameFactory.getName("Little Rascals");
    Population population = PopulationFactory.getTotal(100000);
    Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
    City city = CityFactory.getCity(name, population);
    Province province = ProvinceFactory.getProvince(name, population);
    Address address = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);
    Contact contact = ContactFactory.getContact("0835133305", "fowzia.johannes@gmail.com");

    private Daycare getSavedDaycare()
    {
        Set<Daycare> savedDaycare = this.repository.getAll();
        return  savedDaycare.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = DaycareRepositoryImpl.getRepository();
        this.daycare = DaycareFactory.getDaycare(name, address, contact);
    }

    @Test
    public void aCreate()
    {
        Daycare createdDaycare = this.repository.create(this.daycare);
        System.out.println("Create method called: Created daycare = " + this.daycare);
        dGetAll();
        Assert.assertSame(createdDaycare, this.daycare);
    }

    @Test
    public void bRead()
    {
        Daycare savedDaycare = getSavedDaycare();
        System.out.println("Read method call 1: Reading daycareID = " + savedDaycare.getId());
        Daycare readDaycare = this.repository.read(savedDaycare.getId());
        System.out.println("Read method call 2: Reading read = " + savedDaycare.getId());
        dGetAll();
        Assert.assertSame(savedDaycare, readDaycare);
    }

    @Test
    public void cUpdate()
    {
        Name nm = NameFactory.getName("Big Rascals");
        Daycare newName = new Daycare.Builder().copy(getSavedDaycare()).name(nm).build();
        System.out.println("In update, about_to_updated = " + newName.getName().getname());
        Daycare updated = this.repository.update(newName);
        System.out.println("In update, updated = " + updated.getName().getname());
        Assert.assertSame(newName, updated);
        dGetAll();
    }

    @Test
    public void eDelete()
    {
        Daycare savedDaycare = getSavedDaycare();
        this.repository.delete(savedDaycare.getId());
        dGetAll();
    }

    @Test
    public void dGetAll()
    {
        Set<Daycare> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}