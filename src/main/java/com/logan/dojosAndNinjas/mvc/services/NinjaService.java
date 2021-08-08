package com.logan.dojosAndNinjas.mvc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.logan.dojosAndNinjas.mvc.models.Ninja;
import com.logan.dojosAndNinjas.mvc.repositories.NinjaRepository;

@Service
public class NinjaService {

	// Initialize Repository

	private final NinjaRepository ninjaRepository;

	public NinjaService( NinjaRepository ninjaRepository )
		{ this.ninjaRepository = ninjaRepository; }

	// Create

	public Ninja create( Ninja ninja )
		{ return ninjaRepository.save( ninja ); } // create new ninja

	// Retrieve

	public List< Ninja > findAll()
		{ return ninjaRepository.findAll(); } // find all ninjas

	public Ninja findById( Long id ) {

		Optional< Ninja > optionalNinja = ninjaRepository.findById( id );

		if ( optionalNinja.isPresent() )
			return optionalNinja.get(); // find ninja by id

		return null; // or null

	}

	public List< Ninja > findByFirstName( String firstName )
		{ return ninjaRepository.findByFirstName( firstName ); } // find ninjas by first name

	public List< Ninja > findByLastName( String lastName )
		{ return ninjaRepository.findByLastName( lastName ); } // find ninjas by last name

	public List< Ninja > findByAge( int age )
		{ return ninjaRepository.findByAge( age ); } // find ninjas by age

	// Update

	public Ninja updateFirstName( Long id, String firstName ) {

		Optional< Ninja > optionalNinja = ninjaRepository.findById( id );

		if ( optionalNinja.isPresent() ) {

			Ninja ninja = optionalNinja.get();
			ninja.setId( id );
			ninja.setFirstName( firstName );

			return ninjaRepository.save( ninja ); // update ninja first name

		}

		return null; // or null

	}

	public Ninja updateLastName( Long id, String lastName ) {

		Optional< Ninja > optionalNinja = ninjaRepository.findById( id );
		
		if ( optionalNinja.isPresent() ) {

			Ninja ninja = optionalNinja.get();
			ninja.setId( id );
			ninja.setLastName( lastName );

			return ninjaRepository.save( ninja ); // update ninja last name

		}

		return null; // or null

	}

	public Ninja updateAge( Long id, int age ) {

		Optional< Ninja > optionalNinja = ninjaRepository.findById( id );
		
		if ( optionalNinja.isPresent() ) {

			Ninja ninja = optionalNinja.get();
			ninja.setId( id );
			ninja.setAge( age );

			return ninjaRepository.save( ninja ); // update ninja age

		}

		return null; // or null

	}

	public Ninja update( Long id, @Valid Ninja ninja ) {

		ninja.setId( id );

		return ninjaRepository.save( ninja ); // update ninja with model

	}

	// Delete

	public String delete( Long id ) {

		ninjaRepository.deleteById( id );

		return "Deleted ID " + String.valueOf( id ); // delete ninja by id

	}

}
