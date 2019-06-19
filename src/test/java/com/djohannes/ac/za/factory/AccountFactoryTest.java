package com.djohannes.ac.za.factory;

        import com.djohannes.ac.za.domain.*;
        import org.junit.Assert;
        import org.junit.Test;

public class AccountFactoryTest {

    @Test
    public void getAccount()
    {
        Name sName = NameFactory.getName("Naqeeb", "Johannes");
        Name pName = NameFactory.getName("Dimitri", "Johannes");
        Grade grade = GradeFactory.getGrade("R");
        Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
        Parent parent = ParentFactory.getParent(pName, pContact);

        Name name = NameFactory.getName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
        City city = CityFactory.getCity(name, population);
        Province province = ProvinceFactory.getProvince(name, population);
        Address address = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);

        Student student = StudentFactory.getStudent(sName, grade, "male", 5, address, parent);

        Account account = AccountFactory.getAccount(student, parent, 200.0, 0.0);
        Assert.assertNotNull(account.getId());
        Assert.assertEquals(sName.getFirstName(), account.getStudent().getName().getFirstName());
        Assert.assertEquals(sName.getLastName(), account.getStudent().getName().getLastName());
        Assert.assertEquals(pName.getFirstName(), account.getParent().getName().getFirstName());
        Assert.assertEquals(pName.getLastName(), account.getParent().getName().getLastName());

    }
}