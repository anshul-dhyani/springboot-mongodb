/**
 * 
 */
package com.anshul.springbootmongodb.rest;

import static org.junit.Assert.assertTrue;

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

/**
 * @author anshul
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloWorldTest {

	@LocalServerPort
	private int port;

	TestRestTemplate trt = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testHelloWorld() throws Exception {
		String user = "Anshul";
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = trt.exchange(
				createURLWithPort("/hello/"+user), HttpMethod.GET, entity, String.class);
		int responseCode = response.getStatusCodeValue();
		String value = response.getBody();
		System.out.println("response code: "+responseCode+"  value is: "+value);
		assertTrue(responseCode==200);
		assertTrue(value.contains(user));
	}
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;

    }
}
