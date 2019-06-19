package com.djohannes.ac.za.controller.Allergy;

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
public class AllergyControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/allergy";

    @Test
    public void testGetAllActivities() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetAllergyById() {
        Allergy allergy = restTemplate.getForObject(baseURL + "/allergy/1", Allergy.class);
        System.out.println(allergy.getId());
        assertNotNull(allergy);
    }

    @Test
    public void testCreateAllergy() {
        Allergy allergy = AllergyFactory.getAllergy("cat");

        ResponseEntity<Allergy> postResponse = restTemplate.postForEntity(baseURL + "/create", allergy, Allergy.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println("Post response alphabet: " + postResponse.getBody());
        System.out.println("Allergy allergy: " + allergy.toString());
        Assert.assertEquals(allergy, postResponse.getBody());
    }

    @Test
    public void testUpdateAllergy() {
        int id = 1;
        Allergy allergy = restTemplate.getForObject(baseURL + "/allergy/" + id, Allergy.class);

        restTemplate.put(baseURL + "/allergies/" + id, allergy);
        Allergy updatedAllergy = restTemplate.getForObject(baseURL + "/Allergy/" + id, Allergy.class);
        assertNotNull(updatedAllergy);
    }

    @Test
    public void testDeleteAllergy() {
        int id = 2;
        Allergy allergy = restTemplate.getForObject(baseURL + "/allergies/" + id, Allergy.class);
        assertNotNull(allergy);
        restTemplate.delete(baseURL + "/activities/" + id);
        try {
            allergy = restTemplate.getForObject(baseURL + "/allergies/" + id, Allergy.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
