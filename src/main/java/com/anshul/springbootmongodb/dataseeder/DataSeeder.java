/**
 * 
 */
package com.anshul.springbootmongodb.dataseeder;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.anshul.springbootmongodb.model.Address;
import com.anshul.springbootmongodb.model.POI;
import com.anshul.springbootmongodb.model.Person;
import com.anshul.springbootmongodb.repo.PersonRepository;

/**
 * @author anshul
 *
 */
@Component
public class DataSeeder implements CommandLineRunner {

	private PersonRepository personRepo;

	/**
	 * @param personRepo
	 */
	public DataSeeder(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		// create data
		Person p1 = new Person("ABC", 31, new Address("houseNumber 1", "street", "city", "India", 12345), Arrays
				.asList(new POI("nameOfPoint1", 11.00000d, 11.000d), new POI("nameOfPoint2", 12.00000d, 12.000d)));
		Person p2 = new Person("XYZ", 32, new Address("houseNumber 2", "street", "city", "Belgium", 53213), Arrays
				.asList(new POI("nameOfPoint1", 11.00000d, 11.000d), new POI("nameOfPoint2", 12.00000d, 12.000d)));
		Person p3 = new Person("PQR", 33, new Address("houseNumber 3", "street", "city X", "UK", 13323),
				new ArrayList<POI>());
		// drop existing
		personRepo.deleteAll();

		// add feeder data
		personRepo.saveAll(Arrays.asList(p1, p2, p3));
	}

}
