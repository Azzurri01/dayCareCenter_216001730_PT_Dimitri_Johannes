package com.djohannes.ac.za.controller.address;

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

    @Test
    public void testGetAddressById() {
        Address address = restTemplate.getForObject(baseURL + "/address/1", Address.class);
        System.out.println(address.getId());
        assertNotNull(address);
    }

    @Test
    public void testCreateAddress() {
        Name suburbName = NameFactory.getName("Heideveld");
        Population suburbPopulation = PopulationFactory.getTotal(100000);
        Suburb suburb = SuburbFactory.getSuburb("7764", suburbName, suburbPopulation);

        Name cityName = NameFactory.getName("Cape Town");
        Population cityPopulation = PopulationFactory.getTotal(2000000);
        City city = CityFactory.getCity(cityName, cityPopulation);

        Name provinceName = NameFactory.getName("Western Province");
        Population provincePopulation = PopulationFactory.getTotal(30000000);
        Province province = ProvinceFactory.getProvince(provinceName, provincePopulation);
        Address address = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);

        ResponseEntity<Address> postResponse = restTemplate.postForEntity(baseURL + "/create", address, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println("Post response address: " + postResponse.getBody());
        System.out.println("Address address: " + address.toString());
        Assert.assertEquals(address, postResponse.getBody());
    }

    @Test
    public void testUpdateAddress() {
        int id = 1;
        Address address = restTemplate.getForObject(baseURL + "/address/" + id, Address.class);

        restTemplate.put(baseURL + "/address/" + id, address);
        Address updatedAddress = restTemplate.getForObject(baseURL + "/Address/" + id, Address.class);
        assertNotNull(updatedAddress);
    }

    @Test
    public void testDeleteAddress() {
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
