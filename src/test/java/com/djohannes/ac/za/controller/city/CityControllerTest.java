package com.djohannes.ac.za.controller.city;

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
public class CityControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/city";

    @Test
    public void testGetAllActivities() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetCityById() {
        City city = restTemplate.getForObject(baseURL + "/city/1", City.class);
        System.out.println(city.getId());
        assertNotNull(city);
    }

    @Test
    public void testCreateCity() {
        Name name = NameFactory.getName("Cape Town");
        Population population = PopulationFactory.getTotal(2000000);
        City city = CityFactory.getCity(name, population);

        ResponseEntity<City> postResponse = restTemplate.postForEntity(baseURL + "/create", city, City.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println("Post response rating: " + postResponse.getBody());
        System.out.println("City rating: " + city.toString());
        Assert.assertEquals(city, postResponse.getBody());
    }

    @Test
    public void testUpdateCity() {
        int id = 1;
        City city = restTemplate.getForObject(baseURL + "/city/" + id, City.class);

        restTemplate.put(baseURL + "/cities/" + id, city);
        City updatedCity = restTemplate.getForObject(baseURL + "/City/" + id, City.class);
        assertNotNull(updatedCity);
    }

    @Test
    public void testDeleteCity() {
        int id = 2;
        City city = restTemplate.getForObject(baseURL + "/cities/" + id, City.class);
        assertNotNull(city);
        restTemplate.delete(baseURL + "/activities/" + id);
        try {
            city = restTemplate.getForObject(baseURL + "/cities/" + id, City.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
