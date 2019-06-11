package com.djohannes.ac.za.controller.address;

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
public class AddressControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/address";

    @Test
    public void testGetAllActivities() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetAddressById() {
        Address address = restTemplate.getForObject(baseURL + "/address/1", Address.class);
        System.out.println(address.getId());
        assertNotNull(address);
    }

    @Ignore
    public void testCreateAddress() {
        Name name = NameFactory.getName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
        City city = CityFactory.getCity(name, population);
        Province province = ProvinceFactory.getProvince(name, population);
        Address address = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);

        ResponseEntity<Address> postResponse = restTemplate.postForEntity(baseURL + "/create", address, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateAddress() {
        int id = 1;
        Address address = restTemplate.getForObject(baseURL + "/address/" + id, Address.class);

        restTemplate.put(baseURL + "/addresss/" + id, address);
        Address updatedAddress = restTemplate.getForObject(baseURL + "/Address/" + id, Address.class);
        assertNotNull(updatedAddress);
    }

    @Ignore
    public void testDeleteEmployee() {
        int id = 2;
        Address address = restTemplate.getForObject(baseURL + "/addresss/" + id, Address.class);
        assertNotNull(address);
        restTemplate.delete(baseURL + "/activities/" + id);
        try {
            address = restTemplate.getForObject(baseURL + "/addresss/" + id, Address.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
