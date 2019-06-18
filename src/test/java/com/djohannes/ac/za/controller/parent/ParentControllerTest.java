package com.djohannes.ac.za.controller.parent;

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
public class ParentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/parent";

    @Test
    public void testGetAllParents() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetParentById() {
        Parent parent = restTemplate.getForObject(baseURL + "/parent/1", Parent.class);
        System.out.println(parent.getId());
        assertNotNull(parent);
    }

    @Ignore
    public void testCreateParent() {

        Name pName = NameFactory.getName("Dimitri", "Johannes");
        Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");

        Parent parent = ParentFactory.getParent(pName, pContact);

        ResponseEntity<Parent> postResponse = restTemplate.postForEntity(baseURL + "/create", parent, Parent.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateParent() {
        int id = 1;
        Parent parent = restTemplate.getForObject(baseURL + "/parent/" + id, Parent.class);

        restTemplate.put(baseURL + "/parents/" + id, parent);
        Parent updatedParent = restTemplate.getForObject(baseURL + "/Parent/" + id, Parent.class);
        assertNotNull(updatedParent);
    }

    @Ignore
    public void testDeleteEmployee() {
        int id = 2;
        Parent parent = restTemplate.getForObject(baseURL + "/parents/" + id, Parent.class);
        assertNotNull(parent);
        restTemplate.delete(baseURL + "/parents/" + id);
        try {
            parent = restTemplate.getForObject(baseURL + "/parents/" + id, Parent.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
