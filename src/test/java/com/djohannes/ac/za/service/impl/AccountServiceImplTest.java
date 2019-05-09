package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.AccountRepository;
import com.djohannes.ac.za.repository.impl.AccountRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class AccountServiceImplTest {

    private AccountRepository repository;
    private Account account;

    Name sName = NameFactory.getName("Naqeeb", "Johannes");
    Name pName = NameFactory.getName("Dimitri", "Johannes");
    Grade grade = GradeFactory.getGrade("R");
    Address address = AddressFactory.getAddress("14", "Sentinel road");
    Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
    Parent parent = ParentFactory.getParent(pName, pContact);
    Student student = StudentFactory.getStudent(sName, grade, "male", 5, address, parent);

    private Account getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = AccountRepositoryImpl.getRepository();
        this.account = AccountFactory.getAccount(student, parent, 500, 0);
    }

    @Test
    public void aCreate()
    {
        Account created = this.repository.create(this.account);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.account);
    }

    @Test
    public void bUpdate()
    {
        String newAccountId = "123";
        Account updated = new Account.Builder().copy(getSaved()).id(newAccountId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newAccountId, updated.getId());
    }

    @Test
    public void cDelete()
    {
        Account saved = getSaved();
        this.repository.delete(saved.getId());
        eGetAll();
    }

    @Test
    public void dRead()
    {
        Account saved = getSaved();
        Account read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void eGetAll()
    {
        Set<Account> accounts = this.repository.getAll();
        System.out.println("In getall, all = " + accounts);
    }
}