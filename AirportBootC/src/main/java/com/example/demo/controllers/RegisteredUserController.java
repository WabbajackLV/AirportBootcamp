package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.RegisteredUser;
import com.example.demo.services.IBoardingPassService;
import com.example.demo.services.IFlightService;
import com.example.demo.services.IHelper;
import com.example.demo.services.IRegisteredUserService;

@Controller
@RequestMapping("/registeredUser")
public class RegisteredUserController {
	
	@Autowired
	IRegisteredUserService regUService;
	@Autowired
	IFlightService flightService;
	@Autowired
	IBoardingPassService boardPService;
	@Autowired
	IHelper helperService;
	
	
	/*@GetMapping("/register")//localhost:8080/registeredUser/register
	public String getRegister(RegisteredUser regU)//Its empty customer
	{
		return"register";//register-page.html
	}
	
	@PostMapping("/register")
	public String postRegister(@Valid RegisteredUser regU, BindingResult result)
	{
		System.out.println(regU);
		if(result.hasErrors()) {
			return "register";
		}

		regUService.register(regU.getName(),regU.getSurname(),regU.getAge(),regU.getPhoneNumber(),regU.getEmail(),regU.getPassword());
		return "redirect:/test";
	}*/
	
	
	@GetMapping("/showAllFlights")//localhost:8080/registeredUser/showAllFlights
	public String getShowAllFlights(Model model)
	{
		model.addAttribute("innerObject", helperService.converterHelper());	
		return "show-all-flights";//show-all-product-page.html
		
	}
	
	@GetMapping("/showAllFlights/{id}")//
	public String getShowAllFlightsId(@PathVariable(name = "id")int id, Model model)
	{
	try {
		model.addAttribute("innerObject",helperService.converterHelperForOne(flightService.selectOneFlightById(id)));
		return("show-one-flight");
		}
	catch(Exception e)
		{
			return "error";
		}
	}
	
	@GetMapping("/showMyBookings/{id}")
	public String getShowMyBookingsByRegUId(@PathVariable(name="id")int id,Model model)
	{
		try {
			model.addAttribute("innerObjectBoardPass",regUService.getAllBookingsByRUId(id));
			//model.addAttribute("innerObjectFlight", boardPService.getFlightById(id));
			model.addAttribute("innerObjectRegUName", regUService.selectOneRegisteredUserById(id).getName());
			return "show-all-bookings";
			}
		catch(Exception e)
			{
				return "error";
			}
	}
	
	@GetMapping("/showMyFlights/{id}")
	public String getShowMyFlightsByRegUId(@PathVariable(name="id")int id,Model model)
	{
		try {
			model.addAttribute("innerObjectFlight",regUService.getAllFlightsByRUId(id));
			//model.addAttribute("innerObjectFlight", boardPService.getFlightById(id));
			model.addAttribute("innerObjectRegUName", regUService.selectOneRegisteredUserById(id).getName());
			return "show-all-bookings";
			}
		catch(Exception e)
			{
				return "error";
			}
	}
	
	
	@GetMapping("/showAllFlights/{id}/bookFlight")
	public String getEmail(@PathVariable(name="id")int id,RegisteredUser registeredUser)
	{
			return "enter-email";
	}
	
	@PostMapping("/showAllFlights/{id}/bookFlight") 
	public String postEmail(@PathVariable(name="id")int id,RegisteredUser registeredUser)
	{int idU = 0;
		/*if(result.hasErrors()) {
			return "error";
		}*/
		try {
			
			idU=regUService.bookFlightCustEmail(registeredUser.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:/registeredUser/showMyFlights/"+idU;
	}
	
	
	/*@GetMapping("/showAllFlights/{id}/bookFlight")
	public String getBookFlightByRegUId(@PathVariable(name="id")int id,Model model,RegisteredUser regU)
	{
		try {
			model.addAttribute("innerObjectRegUName", regUService.selectOneRegisteredUserById(id).getName());
			//model.addAttribute("innerObjectFlights", flightService.allFlightsFromAirportToAirport(airportFrom, airportTo));
			return "book-flight";
		}
		catch(Exception e)
			{
			e.printStackTrace();
			return "error";
		}
	}*/
	
	}
