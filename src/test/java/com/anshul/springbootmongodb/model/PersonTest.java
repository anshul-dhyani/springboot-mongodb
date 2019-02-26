/**
 * 
 */
package com.anshul.springbootmongodb.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author anshul
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTest {
	
	@Test
	public void testPerson() {
		Person p1 = new Person("ABC", 31, new Address("houseNumber 1", "street", "city", "India", 12345), Arrays
				.asList(new POI("nameOfPoint1", 11.00000d, 11.000d), new POI("nameOfPoint2", 12.00000d, 12.000d)));
		System.out.println("Test is running. Yayy !!!!!!!!!!!!!");
		assertNotNull(p1);
		assertEquals("ABC", p1.getName());
		assertNotNull(p1.getPointsOfInterest());
	}

}
