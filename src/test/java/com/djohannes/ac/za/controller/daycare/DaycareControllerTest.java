package com.djohannes.ac.za.controller.daycare;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import org.junit.Assert;
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
public class DaycareControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/daycare";

    @Test
    public void testGetAllActivities() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetDaycareById() {
        Daycare daycare = restTemplate.getForObject(baseURL + "/daycare/1", Daycare.class);
        System.out.println(daycare.getId());
        assertNotNull(daycare);
    }

    @Test
    public void testCreateDaycare() {
        Name pName = NameFactory.getName("Dimitri", "Johannes");
        Contact contact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
        Parent parent = ParentFactory.getParent(pName, contact);

        Name name = NameFactory.getName("Little Rascals");
        Population population = PopulationFactory.getTotal(100000);
        Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
        City city = CityFactory.getCity(name, population);
        Province province = ProvinceFactory.getProvince(name, population);
        Address address = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);

        Daycare daycare = DaycareFactory.getDaycare(name, address, contact);

        ResponseEntity<Daycare> postResponse = restTemplate.postForEntity(baseURL + "/create", daycare, Daycare.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println("Post response rating: " + postResponse.getBody());
        System.out.println("Daycare: " + daycare.toString());
        Assert.assertEquals(daycare, postResponse.getBody());
    }

    @Test
    public void testUpdateDaycare() {
        int id = 1;
        Daycare daycare = restTemplate.getForObject(baseURL + "/daycare/" + id, Daycare.class);

        restTemplate.put(baseURL + "/daycares/" + id, daycare);
        Daycare updatedDaycare = restTemplate.getForObject(baseURL + "/Daycare/" + id, Daycare.class);
        assertNotNull(updatedDaycare);
    }

    @Test
    public void testDeleteDaycare() {
        int id = 2;
        Daycare daycare = restTemplate.getForObject(baseURL + "/daycares/" + id, Daycare.class);
        assertNotNull(daycare);
        restTemplate.delete(baseURL + "/daycares/" + id);
        try {
            daycare = restTemplate.getForObject(baseURL + "/daycares/" + id, Daycare.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
