package com.logan.dojosAndNinjas.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.logan.dojosAndNinjas.mvc.models.Dojo;
import com.logan.dojosAndNinjas.mvc.services.DojoService;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

@Controller
@RequestMapping( "/dojo" )
public class DojoController {

	// Initialize Service

	private final DojoService dojoService;

	public DojoController( DojoService dojoService )
		{ this.dojoService = dojoService; }

	// Create

	@RequestMapping( "/new" )
	public String newDojo( Model model ) {

		if ( !model.containsAttribute( "dojo" ) )
			model.addAttribute( "dojo", new Dojo() );
	
		return "/dojo/new.jsp"; // create new dojo form

	}

	@RequestMapping( value = "/new/submit", method = RequestMethod.POST )
	public String submitDojo(

		@Valid @ModelAttribute( "dojo" ) Dojo dojo,
		BindingResult result,
		RedirectAttributes redirectAttributes

	) {

		if ( !result.hasErrors() ) {

				if ( dojoService.findByName( dojo.getName() ) == null ) {

					dojoService.create( dojo );

				} else {

					result.rejectValue( "name", "error.notUnique", "name must be unique" );
					redirectAttributes.addFlashAttribute( "org.springframework.validation.BindingResult.dojo", result);
					redirectAttributes.addFlashAttribute( "dojo", dojo );

					return "redirect:/dojo/new";

				}

		} else {

			redirectAttributes.addFlashAttribute( "org.springframework.validation.BindingResult.dojo", result);
			redirectAttributes.addFlashAttribute( "dojo", dojo );

			return "redirect:/dojo/new";

		}

		return "redirect:/dojo/all"; // create new dojo submit

	}

	// Retrieve

	@RequestMapping( "/all" )
	public String allDojos( Model model ) {

		model.addAttribute( "dojos", dojoService.findAll() );

		return "/dojo/all.jsp"; // all dojos

	}

	@RequestMapping( "/id/{id}/ninjas" )
	public String oneDojo(

		@PathVariable( "id" ) Long id,
		Model model

	) {

		model.addAttribute( "ninjas", dojoService.findById( id ).getNinjas() );
		model.addAttribute( "dojo", dojoService.findById( id ).getName() );

		return "/dojo/ninjas.jsp"; // one dojo's ninjas

	}

}
