package com.djohannes.ac.za.controller.contact;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.impl.ContactRepositoryImpl;
import com.djohannes.ac.za.service.ContactService;
import com.djohannes.ac.za.service.impl.ContactServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import java.net.URI;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ContactControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/contact";

    @Test
    public void testGetAllActivities() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetContactById() {
        Contact contact = restTemplate.getForObject(baseURL + "/contact/1", Contact.class);
        System.out.println(contact.getId());
        assertNotNull(contact);
    }

    @Test
    public void testCreateContact() {
        String tel = "0824512653", email = "dimitri.johannes@gmail.com";
        Contact contact = ContactFactory.getContact(tel, email);

        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(baseURL + "/create", contact , Contact.class);

        System.out.println("Post response contact number: " + postResponse.getBody().getContactNo() + " email: " + postResponse.getBody().getEmail());
        //System.out.println("Contact number: " + contact.getContactNo() + " email: " + contact.getEmail());
    }

    @Test
    public void testUpdateContact() {
        int id = 1;
        Contact contact = restTemplate.getForObject(baseURL + "/contact/" + id, Contact.class);

        restTemplate.put(baseURL + "/contacts/" + id, contact);
        Contact updatedContact = restTemplate.getForObject(baseURL + "/Contact/" + id, Contact.class);
        assertNotNull(updatedContact);
    }

    @Test
    public void testDeleteContact() {
        int id = 2;
        Contact contact = restTemplate.getForObject(baseURL + "/contacts/" + id, Contact.class);
        assertNotNull(contact);
        restTemplate.delete(baseURL + "/activities/" + id);
        try {
            contact = restTemplate.getForObject(baseURL + "/contacts/" + id, Contact.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
