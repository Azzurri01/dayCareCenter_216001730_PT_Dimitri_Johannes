package com.djohannes.ac.za.controller.account;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AccountControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/account";

    @Test
    public void testGetAllAccounts() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetAccountById() {
        Account account = restTemplate.getForObject(baseURL + "/account/1", Account.class);
        System.out.println(account.getId());
        assertNotNull(account);
    }

    @Test
    public void testCreateAccount() {
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

        ResponseEntity<Account> postResponse = restTemplate.postForEntity(baseURL + "/create", account, Account.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateAccount() {
        int id = 1;
        Account account = restTemplate.getForObject(baseURL + "/account/" + id, Account.class);

        restTemplate.put(baseURL + "/accounts/" + id, account);
        Account updatedAccount = restTemplate.getForObject(baseURL + "/Account/" + id, Account.class);
        assertNotNull(updatedAccount);
    }

    @Test
    public void testDeleteAccount() {
        int id = 2;
        Account account = restTemplate.getForObject(baseURL + "/accounts/" + id, Account.class);
        assertNotNull(account);
        restTemplate.delete(baseURL + "/accounts/" + id);
        try {
            account = restTemplate.getForObject(baseURL + "/accounts/" + id, Account.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
