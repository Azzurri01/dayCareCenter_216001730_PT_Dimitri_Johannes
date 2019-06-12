package com.djohannes.ac.za.controller.evaluation;

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
public class EvaluationControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/evaluation";

    @Test
    public void testGetAllActivities() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetEvaluationById() {
        Evaluation evaluation = restTemplate.getForObject(baseURL + "/evaluation/1", Evaluation.class);
        System.out.println(evaluation.getId());
        assertNotNull(evaluation);
    }

    @Test
    public void testCreateEvaluation() {
        Evaluation evaluation = EvaluationFactory.getEvaluation(7);

        ResponseEntity<Evaluation> postResponse = restTemplate.postForEntity(baseURL + "/create", evaluation, Evaluation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateEvaluation() {
        int id = 1;
        Evaluation evaluation = restTemplate.getForObject(baseURL + "/evaluation/" + id, Evaluation.class);

        restTemplate.put(baseURL + "/evaluations/" + id, evaluation);
        Evaluation updatedEvaluation = restTemplate.getForObject(baseURL + "/Evaluation/" + id, Evaluation.class);
        assertNotNull(updatedEvaluation);
    }

    @Test
    public void testDeleteEvaluation() {
        int id = 2;
        Evaluation evaluation = restTemplate.getForObject(baseURL + "/evaluations/" + id, Evaluation.class);
        assertNotNull(evaluation);
        restTemplate.delete(baseURL + "/activities/" + id);
        try {
            evaluation = restTemplate.getForObject(baseURL + "/evaluations/" + id, Evaluation.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
