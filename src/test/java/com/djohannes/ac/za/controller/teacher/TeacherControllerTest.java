package com.djohannes.ac.za.controller.teacher;

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
public class TeacherControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/teacher";

    @Test
    public void testGetAllTeachers() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetTeacherById() {
        Teacher teacher = restTemplate.getForObject(baseURL + "/teacher/1", Teacher.class);
        System.out.println(teacher.getId());
        assertNotNull(teacher);
    }

    @Test
    public void testCreateTeacher() {

        Name tName = NameFactory.getName("Fowzia", "Johannes");
        Contact tContact = ContactFactory.getContact("0835133305", "fowzia.johannes@gmail.com");

        Teacher teacher = TeacherFactory.getTeacher(tName, tContact);

        ResponseEntity<Teacher> postResponse = restTemplate.postForEntity(baseURL + "/create", teacher, Teacher.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateTeacher() {
        int id = 1;
        Teacher teacher = restTemplate.getForObject(baseURL + "/teacher/" + id, Teacher.class);

        restTemplate.put(baseURL + "/teachers/" + id, teacher);
        Teacher updatedTeacher = restTemplate.getForObject(baseURL + "/Teacher/" + id, Teacher.class);
        assertNotNull(updatedTeacher);
    }

    @Test
    public void testDeleteTeacher() {
        int id = 2;
        Teacher teacher = restTemplate.getForObject(baseURL + "/teachers/" + id, Teacher.class);
        assertNotNull(teacher);
        restTemplate.delete(baseURL + "/teachers/" + id);
        try {
            teacher = restTemplate.getForObject(baseURL + "/teachers/" + id, Teacher.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
