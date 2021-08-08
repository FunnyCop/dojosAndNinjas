package com.logan.dojosAndNinjas.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.logan.dojosAndNinjas.mvc.models.Dojo;

public interface DojoRepository extends CrudRepository< Dojo, Long > {

	// Retrieve

	List< Dojo > findAll(); // find all dojos

	Optional< Dojo > findById( Long id ); // find dojo by id or null

	Optional< Dojo > findByName( String name ); // find dojo by name

}
