package com.djohannes.ac.za.controller.classroom;

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
public class ClassroomControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/classroom";

    @Test
    public void testGetAllActivities() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetClassroomById() {
        Classroom classroom = restTemplate.getForObject(baseURL + "/classroom/1", Classroom.class);
        System.out.println(classroom.getId());
        assertNotNull(classroom);
    }

    @Test
    public void testCreateClassroom() {
        Classroom classroom = ClassroomFactory.getClassroom("1");

        ResponseEntity<Classroom> postResponse = restTemplate.postForEntity(baseURL + "/create", classroom, Classroom.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println("Post response rating: " + postResponse.getBody());
        System.out.println("Classroom rating: " + classroom.toString());
        Assert.assertEquals(classroom, postResponse.getBody());
    }

    @Test
    public void testUpdateClassroom() {
        int id = 1;
        Classroom classroom = restTemplate.getForObject(baseURL + "/classroom/" + id, Classroom.class);

        restTemplate.put(baseURL + "/classrooms/" + id, classroom);
        Classroom updatedClassroom = restTemplate.getForObject(baseURL + "/Classroom/" + id, Classroom.class);
        assertNotNull(updatedClassroom);
    }

    @Test
    public void testDeleteClassroom() {
        int id = 2;
        Classroom classroom = restTemplate.getForObject(baseURL + "/classrooms/" + id, Classroom.class);
        assertNotNull(classroom);
        restTemplate.delete(baseURL + "/activities/" + id);
        try {
            classroom = restTemplate.getForObject(baseURL + "/classrooms/" + id, Classroom.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
