
package com.djohannes.ac.za.controller.drawing;

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
public class DrawingControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/drawing";

    @Test
    public void testGetAllActivities() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetDrawingById() {
        Drawing drawing = restTemplate.getForObject(baseURL + "/drawing/1", Drawing.class);
        System.out.println(drawing.getId());
        assertNotNull(drawing);
    }

    @Test
    public void testCreateDrawing() {
        String shape = "circle";
        Evaluation evaluation = EvaluationFactory.getEvaluation(5);
        Drawing drawing = DrawingFactory.getDrawing(shape, evaluation);

        ResponseEntity<Drawing> postResponse = restTemplate.postForEntity(baseURL + "/create", drawing, Drawing.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println("Post response: " + postResponse.getBody());
        System.out.println("Drawing: " + drawing.toString());
        Assert.assertEquals(drawing, postResponse.getBody());
    }

    @Test
    public void testUpdateDrawing() {
        int id = 1;
        Drawing drawing = restTemplate.getForObject(baseURL + "/drawing/" + id, Drawing.class);

        restTemplate.put(baseURL + "/drawings/" + id, drawing);
        Drawing updatedDrawing = restTemplate.getForObject(baseURL + "/Drawing/" + id, Drawing.class);
        assertNotNull(updatedDrawing);
    }

    @Test
    public void testDeleteDrawing() {
        int id = 2;
        Drawing drawing = restTemplate.getForObject(baseURL + "/drawings/" + id, Drawing.class);
        assertNotNull(drawing);
        restTemplate.delete(baseURL + "/activities/" + id);
        try {
            drawing = restTemplate.getForObject(baseURL + "/drawings/" + id, Drawing.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}