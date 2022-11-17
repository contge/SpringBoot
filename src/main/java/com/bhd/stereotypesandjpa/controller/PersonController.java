package com.bhd.stereotypesandjpa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhd.stereotypesandjpa.entity.Person;
import com.bhd.stereotypesandjpa.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@PostMapping({""})
	public ResponseEntity<String> createPerson(@RequestBody Person person){
		
		String documentNumer = personService.createPerson(person);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", documentNumer);
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@GetMapping({"/{documentNumber}"})
	public ResponseEntity<Person> retrievePerson(@PathVariable String documentNumber){
		Person person = null;
		
		try {
			person = personService.retrievePerson(documentNumber);			
		}
		catch(Exception e)
		{
			if(person == null) {
				HttpHeaders headers = new HttpHeaders();
				headers.add("message", "Person not found");
				return new ResponseEntity<>(headers,HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
	
	@DeleteMapping({"/{documentNumber}"})
	public ResponseEntity<Person> deletePerson(@PathVariable String documentNumber){
		
		try {
			personService.deletePerson(documentNumber);			
		}
		catch(Exception e)
		{
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "Person not deleted");
			return new ResponseEntity<>(headers,HttpStatus.NO_CONTENT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Person deleted");
		return new ResponseEntity<>(headers,HttpStatus.NO_CONTENT);
	}
}
