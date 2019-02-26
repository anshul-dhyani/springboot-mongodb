/**
 * 
 */
package com.anshul.springbootmongodb.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anshul
 *
 */
@RestController
@RequestMapping("/hello")
public class HelloWorld {
	@GetMapping("/{name}")
	public String findById(@PathVariable("name") String name) {
		return "Hello " + name;
	}
}
