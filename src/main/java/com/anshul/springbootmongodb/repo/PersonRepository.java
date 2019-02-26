/**
 * 
 */
package com.anshul.springbootmongodb.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.anshul.springbootmongodb.model.Person;

/**
 * @author anshul
 *
 */
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
	Optional<Person> findById(String Id);
	Optional<Person> findByname(String name);
	Optional<List<Person>> findAllByaddress_pincode(int pincode);
}
