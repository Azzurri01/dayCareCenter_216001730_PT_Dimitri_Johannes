package com.djohannes.ac.za.controller.Alphabet;

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
public class AlphabetControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/alphabet";

    @Test
    public void testGetAllActivities() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetAlphabetById() {
        Alphabet alphabet = restTemplate.getForObject(baseURL + "/alphabet/1", Alphabet.class);
        System.out.println(alphabet.getId());
        assertNotNull(alphabet);
    }

    @Test
    public void testCreateAlphabet() {
        Evaluation evaluation = EvaluationFactory.getEvaluation(5);
        Alphabet alphabet = AlphabetFactory.getAlphabet("a",evaluation);

        ResponseEntity<Alphabet> postResponse = restTemplate.postForEntity(baseURL + "/create", alphabet, Alphabet.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void testUpdateAlphabet() {
        int id = 1;
        Alphabet alphabet = restTemplate.getForObject(baseURL + "/alphabet/" + id, Alphabet.class);

        restTemplate.put(baseURL + "/alphabets/" + id, alphabet);
        Alphabet updatedAlphabet = restTemplate.getForObject(baseURL + "/Alphabet/" + id, Alphabet.class);
        assertNotNull(updatedAlphabet);
    }

    @Test
    public void testDeleteAlphabet() {
        int id = 2;
        Alphabet alphabet = restTemplate.getForObject(baseURL + "/alphabets/" + id, Alphabet.class);
        assertNotNull(alphabet);
        restTemplate.delete(baseURL + "/activities/" + id);
        try {
            alphabet = restTemplate.getForObject(baseURL + "/alphabets/" + id, Alphabet.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
