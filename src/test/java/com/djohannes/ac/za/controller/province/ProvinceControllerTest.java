package com.djohannes.ac.za.controller.province;

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
public class ProvinceControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/province";

    @Test
    public void testGetAllProvinces() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetProvinceById() {
        Province province = restTemplate.getForObject(baseURL + "/province/1", Province.class);
        System.out.println(province.getId());
        assertNotNull(province);
    }

    @Test
    public void testCreateProvince() {

        Name name = NameFactory.getName("Western Province");
        Population population = PopulationFactory.getTotal(10000000);
        Province province = ProvinceFactory.getProvince(name, population);

        ResponseEntity<Province> postResponse = restTemplate.postForEntity(baseURL + "/create", province, Province.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateProvince() {
        int id = 1;
        Province province = restTemplate.getForObject(baseURL + "/province/" + id, Province.class);

        restTemplate.put(baseURL + "/provinces/" + id, province);
        Province updatedProvince = restTemplate.getForObject(baseURL + "/Province/" + id, Province.class);
        assertNotNull(updatedProvince);
    }

    @Test
    public void testDeleteProvince() {
        int id = 2;
        Province province = restTemplate.getForObject(baseURL + "/provinces/" + id, Province.class);
        assertNotNull(province);
        restTemplate.delete(baseURL + "/provinces/" + id);
        try {
            province = restTemplate.getForObject(baseURL + "/provinces/" + id, Province.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
