package com.logan.dojosAndNinjas.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.logan.dojosAndNinjas.mvc.models.Ninja;

public interface NinjaRepository extends CrudRepository< Ninja, Long > {

	// Retrieve

	List< Ninja > findAll(); // find all ninjas

	Optional< Ninja > findById( Long id ); // find ninja by id or null

	List< Ninja > findByFirstName( String firstName ); // find ninja by first name

	List< Ninja > findByLastName( String lastName ); // find ninja by last name

	List< Ninja > findByAge( int age ); // find ninja by age

}
