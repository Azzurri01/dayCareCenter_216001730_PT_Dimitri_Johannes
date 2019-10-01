package com.djohannes.ac.za.controller.counting;

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
public class CountingControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/counting";

    @Test
    public void testGetAllActivities() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetCountingById() {
        Counting counting = restTemplate.getForObject(baseURL + "/counting/1", Counting.class);
        System.out.println(counting.getId());
        assertNotNull(counting);
    }

    @Test
    public void testCreateCounting() {
        Counting counting = CountingFactory.getCounting(5);

        ResponseEntity<Counting> postResponse = restTemplate.postForEntity(baseURL + "/create", counting, Counting.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println("Post response: " + postResponse.getBody());
        System.out.println("Counting: " + counting.toString());
        Assert.assertEquals(counting, postResponse.getBody());
    }

    @Test
    public void testUpdateCounting() {
        int id = 1;
        Counting counting = restTemplate.getForObject(baseURL + "/counting/" + id, Counting.class);

        restTemplate.put(baseURL + "/numbers/" + id, counting);
        Counting updatedCounting = restTemplate.getForObject(baseURL + "/Counting/" + id, Counting.class);
        assertNotNull(updatedCounting);
    }

    @Test
    public void testDeleteCounting() {
        int id = 2;
        Counting counting = restTemplate.getForObject(baseURL + "/numbers/" + id, Counting.class);
        assertNotNull(counting);
        restTemplate.delete(baseURL + "/numbers/" + id);
        try {
            counting = restTemplate.getForObject(baseURL + "/numbers/" + id, Counting.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
