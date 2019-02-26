/**
 * 
 */
package com.anshul.springbootmongodb.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.anshul.springbootmongodb.model.Address;
import com.anshul.springbootmongodb.model.POI;
import com.anshul.springbootmongodb.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author anshul
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PeopleRestControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate trt = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testPeopleCreation() throws Exception {
		Person person = new Person("Person1", 31, new Address("houseNumber 1", "street", "city", "India", 12345), Arrays
				.asList(new POI("nameOfPoint1", 11.00000d, 11.000d), new POI("nameOfPoint2", 12.00000d, 12.000d)));
		HttpEntity<Person> entity = new HttpEntity<Person>(person);
		ResponseEntity<String> response = trt.exchange(createURLWithPort("/people"), HttpMethod.POST, entity,
				String.class);
		int responseCode = response.getStatusCodeValue();
		String value = response.getBody();
		System.out.println("response code: " + responseCode + "  value is: " + value);
		assertTrue(responseCode == 201);
		
		//check for the inserted data in DB using another endpoint
		ResponseEntity<String> response2 = trt.exchange(createURLWithPort("/people/name/Person1"), HttpMethod.GET, entity,
				String.class);
		int responseCode2 = response2.getStatusCodeValue();
		String value2 = response2.getBody();
		Person personFound2 = new ObjectMapper().readValue(value2,Person.class);
		System.out.println("response code: " + responseCode2 + "  value is: " + value2);
		assertTrue(responseCode2 == 200);
		assertNotNull(personFound2);
		assertTrue(personFound2.getName().equalsIgnoreCase("Person1"));
	}

	@Test
	public void testGetAll() throws Exception {

		HttpEntity<List<Person>> entity = new HttpEntity<>(null);
		ResponseEntity<String> response = trt.exchange(createURLWithPort("/people/all"), HttpMethod.GET, entity,
				String.class);
		int responseCode = response.getStatusCodeValue();
		String value = response.getBody();
		List<Person> resultList = new ObjectMapper().readValue(value, new TypeReference<List<Person>>() {
		});
		System.out.println("response code: " + responseCode + "  value is: " + value);
		assertTrue(responseCode == 200);
		assertNotNull(resultList);
	}

//	@Test
//	public void testFindByName() throws Exception {
//
//		HttpEntity<List<Person>> entity = new HttpEntity<>(null);
//		ResponseEntity<String> response = trt.exchange(createURLWithPort("/people/name/Person1"), HttpMethod.GET, entity,
//				String.class);
//		int responseCode = response.getStatusCodeValue();
//		String value = response.getBody();
//		Person personFound = new ObjectMapper().readValue(value,Person.class);
//		System.out.println("response code: " + responseCode + "  value is: " + value);
//		assertTrue(responseCode == 200);
//		assertNotNull(personFound);
//		assertTrue(personFound.getName().equalsIgnoreCase("Person1"));
//	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;

	}
}
