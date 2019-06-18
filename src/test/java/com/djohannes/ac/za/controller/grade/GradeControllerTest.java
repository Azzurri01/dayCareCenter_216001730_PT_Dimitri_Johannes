package com.djohannes.ac.za.controller.grade;

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
public class GradeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/grade";

    @Test
    public void testGetAllGrades() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetGradeById() {
        Grade grade = restTemplate.getForObject(baseURL + "/grade/1", Grade.class);
        System.out.println(grade.getId());
        assertNotNull(grade);
    }

    @Ignore
    public void testCreateGrade() {
        Grade grade = GradeFactory.getGrade("R");

        ResponseEntity<Grade> postResponse = restTemplate.postForEntity(baseURL + "/create", grade, Grade.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateGrade() {
        int id = 1;
        Grade grade = restTemplate.getForObject(baseURL + "/grade/" + id, Grade.class);

        restTemplate.put(baseURL + "/grades/" + id, grade);
        Grade updatedGrade = restTemplate.getForObject(baseURL + "/Grade/" + id, Grade.class);
        assertNotNull(updatedGrade);
    }

    @Ignore
    public void testDeleteEmployee() {
        int id = 2;
        Grade grade = restTemplate.getForObject(baseURL + "/grades/" + id, Grade.class);
        assertNotNull(grade);
        restTemplate.delete(baseURL + "/grades/" + id);
        try {
            grade = restTemplate.getForObject(baseURL + "/grades/" + id, Grade.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
