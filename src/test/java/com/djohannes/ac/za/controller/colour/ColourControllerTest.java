package com.djohannes.ac.za.controller.colour;

import com.djohannes.ac.za.domain.colour.Colour;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ColourControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/dccs/colour";

    @Test
    public void testGetAll() {
        ResponseEntity result = restTemplate.withBasicAuth("dimitri", "cputPTguest")
                .getForEntity(baseURL + "/getall", String.class);
        System.out.println(result.getBody());
        Assert.assertEquals(HttpStatus.OK, result.getStatusCodeValue());
    }

    @Test
    public void testGetColourById() {
        Colour colour = restTemplate.getForObject(baseURL + "/colour/1", Colour.class);
        System.out.println(colour.getId());
        assertNotNull(colour);
    }

    @Test
    public void testCreateColour() {
                ResponseEntity result = restTemplate.withBasicAuth("admin", "cputPTadmin")
                .postForEntity( baseURL + "/create/red", MediaType.APPLICATION_JSON, String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testUpdateColour() {
        int id = 1;
        Colour colour = restTemplate.getForObject(baseURL + "/colour/" + id, Colour.class);

        restTemplate.put(baseURL + "/colours/" + id, colour);
        Colour updatedColour = restTemplate.getForObject(baseURL + "/Colour/" + id, Colour.class);
        assertNotNull(updatedColour);
    }

    @Test
    public void testDeleteColour() {
        int id = 2;
        Colour colour = restTemplate.getForObject(baseURL + "/colours/" + id, Colour.class);
        assertNotNull(colour);
        restTemplate.delete(baseURL + "/activities/" + id);
        try {
            colour = restTemplate.getForObject(baseURL + "/colours/" + id, Colour.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
