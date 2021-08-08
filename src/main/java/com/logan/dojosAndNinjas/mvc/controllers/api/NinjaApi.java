package com.logan.dojosAndNinjas.mvc.controllers.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logan.dojosAndNinjas.mvc.models.Dojo;
import com.logan.dojosAndNinjas.mvc.models.Ninja;
import com.logan.dojosAndNinjas.mvc.services.DojoService;
import com.logan.dojosAndNinjas.mvc.services.NinjaService;

@RestController
@RequestMapping( "/api/ninja" )
public class NinjaApi {

	// Initialize Service

	private final NinjaService ninjaService;
	private final DojoService dojoService;

	public NinjaApi(

		NinjaService ninjaService,
		DojoService dojoService

	) {

		this.ninjaService = ninjaService; // NinjaService
		this.dojoService = dojoService; // DojoService

	}

	// Create

	@RequestMapping( value = "/create", method = RequestMethod.POST )
	public Ninja create(

		@RequestParam( "firstName" ) String firstName,
		@RequestParam( "lastName" ) String lastName,
		@RequestParam( "age" ) int age,
		@RequestParam( "dojoId" ) Long dojoId

	) {

		Dojo dojo = dojoService.findById( dojoId );

		if ( dojo == null )
			return null;

		Ninja ninja = new Ninja( firstName, lastName, age, dojo );

		return ninjaService.create( ninja ); // create new ninja

	}

	// Retrieve

	@RequestMapping( value = "/all", method = RequestMethod.GET )
	public List< Ninja > findAll()
		{ return ninjaService.findAll(); } // find all ninjas

	@RequestMapping( value = "/id/{id}", method = RequestMethod.GET )
	public Ninja findById( @PathVariable( "id" ) Long id )
		{ return ninjaService.findById( id ); } // find ninja by id

	@RequestMapping( value = "/first_name/{firstName}", method = RequestMethod.GET )
	public List< Ninja > findByFirstName( @PathVariable( "firstName" ) String firstName )
		{ return ninjaService.findByFirstName( firstName ); } // find ninja by first name

	@RequestMapping( value = "/last_name/{lastName}", method = RequestMethod.GET )
	public List< Ninja > findByLastName( @PathVariable( "lastName" ) String lastName )
		{ return ninjaService.findByLastName( lastName ); } // find ninja by last name

	@RequestMapping( value = "/age/{age}", method = RequestMethod.GET )
	public List< Ninja > findByAge( @PathVariable( "age" ) int age )
		{ return ninjaService.findByAge( age ); } // find ninja by age

	// Update

	@RequestMapping( value = "/update/first_name/{id}", method = RequestMethod.PUT )
	public Ninja updateFirstName(

		@PathVariable( "id" ) Long id,
		@RequestParam( "firstName" ) String firstName

	) {

		return ninjaService.updateFirstName( id, firstName ); // update ninja first name

	}

	@RequestMapping( value = "/update/last_name/{id}", method = RequestMethod.PUT )
	public Ninja updateLastName(

		@PathVariable( "id" ) Long id,
		@RequestParam( "lastName" ) String lastName

	) {

		return ninjaService.updateLastName( id, lastName ); // update ninja last name

	}
	
	@RequestMapping( value = "/update/age/{id}", method = RequestMethod.PUT )
	public Ninja updateAge(

		@PathVariable( "id" ) Long id,
		@RequestParam( "age" ) int age

	) {

		return ninjaService.updateAge( id, age ); // update ninja age

	}

	// Delete

	@RequestMapping( value = "/delete/{id}", method = RequestMethod.DELETE )
	public String delete( @PathVariable( "id" ) Long id )
		{ return ninjaService.delete( id ); } // delete ninja by id

}







