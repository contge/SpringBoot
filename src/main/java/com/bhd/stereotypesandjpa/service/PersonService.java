package com.bhd.stereotypesandjpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhd.stereotypesandjpa.Repository.PersonRepository;
import com.bhd.stereotypesandjpa.entity.Person;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRespository;
	
	public String createPerson(Person person) {
		
		personRespository.save(person);
		
		return person.getDocumentNumber();
	}
	
	public Person retrievePerson(String documentNumber) {
		
		return personRespository.findById(documentNumber).get();
	}
	
	public boolean deletePerson(String documentNumber) {
		personRespository.deleteById(documentNumber);
		return true;
	}
}
