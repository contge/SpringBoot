package com.bhd.stereotypesandjpa.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bhd.stereotypesandjpa.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
	
	
	
}
