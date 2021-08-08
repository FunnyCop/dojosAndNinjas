package com.logan.dojosAndNinjas.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.logan.dojosAndNinjas.mvc.models.Dojo;
import com.logan.dojosAndNinjas.mvc.models.Ninja;
import com.logan.dojosAndNinjas.mvc.services.DojoService;
import com.logan.dojosAndNinjas.mvc.services.NinjaService;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping( "/ninja" )
public class NinjaController {

	// Initialize Service

	private final DojoService dojoService;
	private final NinjaService ninjaService;

	public NinjaController(

		DojoService dojoService,
		NinjaService ninjaService

	) {

		this.dojoService = dojoService;
		this.ninjaService = ninjaService;

	}

	// Create

	@RequestMapping( "/new" )
	public String newninja( Model model ) {

		if ( !model.containsAttribute( "ninja" ) )
			model.addAttribute( "ninja", new Ninja() );

		model.addAttribute( "dojos", dojoService.findAll() );
	
		return "/ninja/new.jsp"; // create new ninja form

	}

	@RequestMapping( value = "/new/submit", method = RequestMethod.POST )
	public String submitNinja(

		@Valid @ModelAttribute( "ninja" ) Ninja ninja,
		BindingResult result,
		RedirectAttributes redirectAttributes

	) {

		if ( !result.hasErrors() )
			ninjaService.create( ninja );

		else {

			redirectAttributes.addFlashAttribute( "org.springframework.validation.BindingResult.ninja", result);
			redirectAttributes.addFlashAttribute( "ninja", ninja );

			return "redirect:/ninja/new";

		}

		return "redirect:/dojo/all"; // create new ninja submit

	}

}
