
package com.djohannes.ac.za.controller.name;

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
public class NameControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/name";

    @Test
    public void testGetAllNames() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetNameById() {
        Name name = restTemplate.getForObject(baseURL + "/name/1", Name.class);
        System.out.println(name.getId());
        assertNotNull(name);
    }

    @Ignore
    public void testCreateName() {
        Name name = NameFactory.getName("Dimitri", "Johannes");

        ResponseEntity<Name> postResponse = restTemplate.postForEntity(baseURL + "/create", name, Name.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateName() {
        int id = 1;
        Name name = restTemplate.getForObject(baseURL + "/name/" + id, Name.class);

        restTemplate.put(baseURL + "/names/" + id, name);
        Name updatedName = restTemplate.getForObject(baseURL + "/Name/" + id, Name.class);
        assertNotNull(updatedName);
    }

    @Ignore
    public void testDeleteEmployee() {
        int id = 2;
        Name name = restTemplate.getForObject(baseURL + "/names/" + id, Name.class);
        assertNotNull(name);
        restTemplate.delete(baseURL + "/names/" + id);
        try {
            name = restTemplate.getForObject(baseURL + "/names/" + id, Name.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}