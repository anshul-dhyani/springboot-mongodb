/**
 * 
 */
package com.anshul.springbootmongodb.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anshul.springbootmongodb.model.Person;
import com.anshul.springbootmongodb.repo.PersonRepository;

/**
 * @author anshul
 *
 */
@RestController
@RequestMapping("/people")
public class PeopleRestController {
	private PersonRepository personRepo;

	/**
	 * @param personRepo
	 */
	public PeopleRestController(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}

	@PostMapping
	public ResponseEntity<Person> insert(@RequestBody Person person) {
		Person p = this.personRepo.insert(person);
		return new ResponseEntity<Person>(p, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<Person> getAll() {
		return this.personRepo.findAll();
	}

	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") String id) {
		return this.personRepo.findById(id).orElse(null);
	}
	
	@GetMapping("/name/{name}")
	public Person findByName(@PathVariable("name") String name) {
		return this.personRepo.findByname(name).orElse(null);
	}
	
	@GetMapping("/pin/{pin}")
	public List<Person> findByPinCode(@PathVariable() int pin) {
		return this.personRepo.findAllByaddress_pincode(pin).orElse(null);
	}
	@PutMapping
	public void update(@RequestBody Person person) {
		this.personRepo.save(person); // save does upsert.
	}

	@DeleteMapping
	public void delete(@PathVariable("id") String id) {
		this.personRepo.deleteById(id);
	}

}
