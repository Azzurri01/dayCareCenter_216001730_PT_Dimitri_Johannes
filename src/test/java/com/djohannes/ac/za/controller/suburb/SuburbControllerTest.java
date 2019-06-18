package com.djohannes.ac.za.controller.suburb;

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
public class SuburbControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/suburb";

    @Test
    public void testGetAllSuburbs() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetSuburbById() {
        Suburb suburb = restTemplate.getForObject(baseURL + "/suburb/1", Suburb.class);
        System.out.println(suburb.getId());
        assertNotNull(suburb);
    }

    @Ignore
    public void testCreateSuburb() {

        Name name = NameFactory.getName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        Suburb suburb = SuburbFactory.getSuburb( "7764", name, population);

        ResponseEntity<Suburb> postResponse = restTemplate.postForEntity(baseURL + "/create", suburb, Suburb.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateSuburb() {
        int id = 1;
        Suburb suburb = restTemplate.getForObject(baseURL + "/suburb/" + id, Suburb.class);

        restTemplate.put(baseURL + "/suburbs/" + id, suburb);
        Suburb updatedSuburb = restTemplate.getForObject(baseURL + "/Suburb/" + id, Suburb.class);
        assertNotNull(updatedSuburb);
    }

    @Ignore
    public void testDeleteEmployee() {
        int id = 2;
        Suburb suburb = restTemplate.getForObject(baseURL + "/suburbs/" + id, Suburb.class);
        assertNotNull(suburb);
        restTemplate.delete(baseURL + "/suburbs/" + id);
        try {
            suburb = restTemplate.getForObject(baseURL + "/suburbs/" + id, Suburb.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
