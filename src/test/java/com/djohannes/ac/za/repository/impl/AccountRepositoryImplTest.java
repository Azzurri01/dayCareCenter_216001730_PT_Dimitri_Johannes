package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.AccountRepository;
import com.djohannes.ac.za.util.Misc;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountRepositoryImplTest {

    private AccountRepository repository;
    private Account account;

    private Name sName = NameFactory.getName("Naqeeb", "Johannes");
    private Name pName = NameFactory.getName("Dimitri", "Johannes");
    private Grade grade = GradeFactory.getGrade("R");
    private Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
    private Parent parent = ParentFactory.getParent(pName, pContact);

    Name name = NameFactory.getName("Heideveld");
    Population population = PopulationFactory.getTotal(100000);
    Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
    City city = CityFactory.getCity(name, population);
    Province province = ProvinceFactory.getProvince(name, population);
    Address address = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);

    private Student student = StudentFactory.getStudent(sName, grade, "male", 5, address, parent);

    private Account getSavedAccount()
    {
        Set<Account> savedAccount = this.repository.getAll();
        return  savedAccount.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = AccountRepositoryImpl.getRepository();
        this.account = AccountFactory.getAccount(student, parent, 500, 100);
    }

    @Test
    public void aCreate()
    {
        Account createdAccount = this.repository.create(this.account);
        System.out.println("Create method called: Created account = " + this.account);
        dGetAll();
        Assert.assertSame(createdAccount, this.account);
    }

    @Test
    public void bRead()
    {
        Account savedAccount = getSavedAccount();
        System.out.println("Read method call 1: Reading account = " + savedAccount);
        Account readAccount = this.repository.read(savedAccount.getId());
        System.out.println("Read method call 2: Reading read = " + readAccount);
        dGetAll();
        Assert.assertSame(savedAccount, readAccount);
    }

    @Test
    public void cUpdate()
    {
        Name name = NameFactory.getName("Dimitri", "Johannes");
        Contact contact = ContactFactory.getContact("0824512653", "dimitri.johannes@t-systems.co.za");
        Parent parent = ParentFactory.getParent(name, contact);
        Account newAccount = new Account.Builder().copy(getSavedAccount()).parent(parent).build();
        System.out.println("In update, about_to_updated = " + newAccount);
        Account updated = this.repository.update(newAccount);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newAccount, updated);
        dGetAll();
    }

    @Test
    public void eDelete()
    {
        Account savedAccount = getSavedAccount();
        this.repository.delete(savedAccount.getId());
        dGetAll();
    }

    @Test
    public void dGetAll()
    {
        Set<Account> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}