package com.djohannes.ac.za.controller.counting;

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

    @Ignore
    public void testGetCountingById() {
        Counting counting = restTemplate.getForObject(baseURL + "/counting/1", Counting.class);
        System.out.println(counting.getId());
        assertNotNull(counting);
    }

    @Ignore
    public void testCreateCounting() {
        Evaluation evaluation = EvaluationFactory.getEvaluation(5);
        Counting counting = CountingFactory.getCounting(5,evaluation);

        ResponseEntity<Counting> postResponse = restTemplate.postForEntity(baseURL + "/create", counting, Counting.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateCounting() {
        int id = 1;
        Counting counting = restTemplate.getForObject(baseURL + "/counting/" + id, Counting.class);

        restTemplate.put(baseURL + "/numbers/" + id, counting);
        Counting updatedCounting = restTemplate.getForObject(baseURL + "/Counting/" + id, Counting.class);
        assertNotNull(updatedCounting);
    }

    @Ignore
    public void testDeleteEmployee() {
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
