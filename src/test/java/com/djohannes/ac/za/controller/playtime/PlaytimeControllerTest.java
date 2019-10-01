package com.djohannes.ac.za.controller.playtime;

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
public class PlaytimeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/playtime";

    @Test
    public void testGetAllPlaytimes() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetPlaytimeById() {
        Playtime playtime = restTemplate.getForObject(baseURL + "/playtime/1", Playtime.class);
        System.out.println(playtime.getId());
        assertNotNull(playtime);
    }

    @Test
    public void testCreatePlaytime() {

        Playtime playtime = PlaytimeFactory.getPlaytime("social");

        ResponseEntity<Playtime> postResponse = restTemplate.postForEntity(baseURL + "/create", playtime, Playtime.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println("Post response: " + postResponse.getBody());
        System.out.println("Playtime: " + playtime.toString());
        Assert.assertEquals(playtime, postResponse.getBody());
    }

    @Test
    public void testUpdatePlaytime() {
        int id = 1;
        Playtime playtime = restTemplate.getForObject(baseURL + "/playtime/" + id, Playtime.class);

        restTemplate.put(baseURL + "/playtimes/" + id, playtime);
        Playtime updatedPlaytime = restTemplate.getForObject(baseURL + "/Playtime/" + id, Playtime.class);
        assertNotNull(updatedPlaytime);
    }

    @Test
    public void testDeletePlaytime() {
        int id = 2;
        Playtime playtime = restTemplate.getForObject(baseURL + "/playtimes/" + id, Playtime.class);
        assertNotNull(playtime);
        restTemplate.delete(baseURL + "/playtimes/" + id);
        try {
            playtime = restTemplate.getForObject(baseURL + "/playtimes/" + id, Playtime.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
