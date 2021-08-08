package com.logan.dojosAndNinjas.mvc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.logan.dojosAndNinjas.mvc.models.Dojo;
import com.logan.dojosAndNinjas.mvc.repositories.DojoRepository;

@Service
public class DojoService {

	// Initialize Repository

	private final DojoRepository dojoRepository;

	public DojoService( DojoRepository dojoRepository )
		{ this.dojoRepository = dojoRepository; }

	// Create

	public Dojo create( Dojo dojo ) {

		Optional< Dojo > optionalDojo = dojoRepository.findByName( dojo.getName() );

		if ( optionalDojo.isEmpty() )
			return dojoRepository.save( dojo ); // create new dojo

		return null; // or null

	}

	// Retrieve

	public List< Dojo > findAll()
		{ return dojoRepository.findAll(); } // find all dojos

	public Dojo findById( Long id ) {

		Optional< Dojo > optionalDojo = dojoRepository.findById( id );

		if ( optionalDojo.isPresent() )
			return optionalDojo.get(); // find dojo by id

		return null; // or null

	}

	public Dojo findByName( String name ) {

		Optional< Dojo > optionalDojo = dojoRepository.findByName( name );

		if ( optionalDojo.isPresent() )
			return optionalDojo.get();

		return null; // find dojo by name

	}

	// Update

	public Dojo updateName( Long id, String name ) {

		Optional< Dojo > optionalDojo = dojoRepository.findById( id );

		if ( optionalDojo.isPresent() ) {

			Optional< Dojo > existingDojo = dojoRepository.findByName( name );

			if ( existingDojo.isEmpty() ) {

				Dojo dojo = optionalDojo.get();
				dojo.setId( id );
				dojo.setName( name );

				return dojoRepository.save( dojo ); // update dojo name

			}

		}

		return null; // or null
	}

	public Dojo update( Long id, @Valid Dojo dojo ) {

		dojo.setId( id );

		Optional< Dojo > optionalDojo = dojoRepository.findByName( dojo.getName() );

		if ( optionalDojo.isEmpty() )
			return dojoRepository.save( dojo ); // update dojo with model

		return null; // or null

	}

	// Delete

	public String delete( Long id ) {

		dojoRepository.deleteById( id );

		return "Deleted ID " + String.valueOf( id ); // delete dojo by id

	}

}
