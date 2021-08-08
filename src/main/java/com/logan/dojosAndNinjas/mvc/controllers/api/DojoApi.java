package com.logan.dojosAndNinjas.mvc.controllers.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logan.dojosAndNinjas.mvc.models.Dojo;
import com.logan.dojosAndNinjas.mvc.services.DojoService;

@RestController
@RequestMapping( "/api/dojo" )
public class DojoApi {

	// Initialize Service

	private final DojoService dojoService;

	public DojoApi( DojoService dojoService )
		{ this.dojoService = dojoService; } // DojoService

	// Create

	@RequestMapping( value = "/create", method = RequestMethod.POST )
	public Dojo create( @RequestParam( "name" ) String name ) {

		Dojo dojo = new Dojo( name );

		return dojoService.create( dojo ); // create new dojo

	}

	// Retrieve

	@RequestMapping( value = "/all", method = RequestMethod.GET )
	public List< Dojo > findAll()
		{ return dojoService.findAll(); } // find all dojos

	@RequestMapping( value = "/id/{id}", method = RequestMethod.GET )
	public Dojo findById( @PathVariable( "id" ) Long id )
		{ return dojoService.findById( id ); } // find dojo by id

	@RequestMapping( value = "/name/{name}", method = RequestMethod.GET )
	public Dojo findByName( @PathVariable( "name" ) String name )
		{ return dojoService.findByName( name ); } // find dojo by name

	// Update

	@RequestMapping( value = "/update/{id}", method = RequestMethod.PUT )
	public Dojo updateName(

		@PathVariable( "id" ) Long id,
		@RequestParam( "name" ) String name

	) {

		return dojoService.updateName( id, name ); // update dojo name

	}

	// Delete

	@RequestMapping( value = "/delete/{id}", method = RequestMethod.DELETE )
	public String delete( @PathVariable( "id" ) Long id )
		{ return dojoService.delete( id ); } // delete dojo by id

}
