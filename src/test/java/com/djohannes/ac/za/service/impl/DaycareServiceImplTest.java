package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.DaycareRepository;
import com.djohannes.ac.za.repository.impl.DaycareRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class DaycareServiceImplTest {

    private DaycareRepository repository;
    private Daycare daycare;

    Name name = NameFactory.getName("Little Rascals");
    Population population = PopulationFactory.getTotal(100000);
    Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
    City city = CityFactory.getCity(name, population);
    Province province = ProvinceFactory.getProvince(name, population);
    Address address = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);
    Contact contact = ContactFactory.getContact("0835133305", "fowzia.johannes@gmail.com");

    private Daycare getSaved(){
        return this.repository.getAll().iterator().next();
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
        Daycare created = this.repository.create(this.daycare);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.daycare);
    }

    @Test
    public void cUpdate()
    {
        String newDaycareId = "123";
        Daycare updated = new Daycare.Builder().copy(getSaved()).id(newDaycareId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newDaycareId, updated.getId());
    }

    @Test
    public void eDelete()
    {
        Daycare saved = getSaved();
        this.repository.delete(saved.getId());
        dGetAll();
    }

    @Test
    public void bRead()
    {
        Daycare saved = getSaved();
        Daycare read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void dGetAll()
    {
        Set<Daycare> daycares = this.repository.getAll();
        System.out.println("In getall, all = " + daycares);
    }
}