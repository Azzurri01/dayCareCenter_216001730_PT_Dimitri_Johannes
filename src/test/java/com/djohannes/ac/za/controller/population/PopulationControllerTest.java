
package com.djohannes.ac.za.controller.population;

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
public class PopulationControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/population";

    @Test
    public void testGetAllPopulations() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetPopulationById() {
        Population population = restTemplate.getForObject(baseURL + "/population/1", Population.class);
        System.out.println(population.getId());
        assertNotNull(population);
    }

    @Ignore
    public void testCreatePopulation() {

        Population population = PopulationFactory.getTotal(1000000);

        ResponseEntity<Population> postResponse = restTemplate.postForEntity(baseURL + "/create", population, Population.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdatePopulation() {
        int id = 1;
        Population population = restTemplate.getForObject(baseURL + "/population/" + id, Population.class);

        restTemplate.put(baseURL + "/populations/" + id, population);
        Population updatedPopulation = restTemplate.getForObject(baseURL + "/Population/" + id, Population.class);
        assertNotNull(updatedPopulation);
    }

    @Ignore
    public void testDeleteEmployee() {
        int id = 2;
        Population population = restTemplate.getForObject(baseURL + "/populations/" + id, Population.class);
        assertNotNull(population);
        restTemplate.delete(baseURL + "/populations/" + id);
        try {
            population = restTemplate.getForObject(baseURL + "/populations/" + id, Population.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}