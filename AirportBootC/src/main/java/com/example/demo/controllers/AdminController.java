package com.example.demo.controllers;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.Valid;

import org.apache.catalina.LifecycleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Airport;
import com.example.demo.models.Flight;
import com.example.demo.services.IAdminService;
import com.example.demo.services.IAirportService;
import com.example.demo.services.IFlightService;
import com.example.demo.utils.FlightInformation;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IAdminService adminService;
	
	@Autowired
	IFlightService flightService;
	
	@Autowired
	IAirportService airportService;

	@GetMapping("/showAllFlights")
	public String getShowAllFlightsAdmin(Model model) {
		model.addAttribute("innerObject", flightService.selectAllFlights());
		return "show-all-flights";
	}
	
	
	@GetMapping("/newFlight")//url address -> localhost:8080/admin/newFlight
	public String getNewFlight(Flight flight){
		return "new-flight";//new-flight.html
	}
	
	@PostMapping("/newFlight")//it will be called when SUBMIT button is pressed
	public String postNewFlight(@Valid Flight flight, BindingResult result)
	{
		System.out.println(flight.toString());
		if(result.hasErrors()) {
			return "new-flight";
		}
		ArrayList<Airport> airports = new ArrayList<Airport>(flight.getAirportFromAndTo());
		flightService.createNewFlight(airports.get(0), airports.get(1), flight.getDepartureDate(), flight.getFlightDuration(), flight.getPassengerCapacity(), flight.getPrice());
		return "redirect:/admin/showAllFlightsAdmin";
	}
	
	@GetMapping("/newFlight2")
	public String getNewFlight2(FlightInformation flightInformation, Model model){
		model.addAttribute("airports", airportService.getAllAirports());
		return "new-flight2";
	}
	
	@PostMapping("/newFlight2")//it will be called when SUBMIT button is pressed
	public String postNewFlight2(FlightInformation flightInformation, BindingResult result)
	{
		System.out.println("FLIGHT_INFORMATION " + flightInformation.toString());
		/*
		if(result.hasErrors()) {
			System.out.println("ERRORS ");
			return "new-flight2";
		}
		*/
		flightService.createNewFlight(flightInformation.getAirportFrom(), flightInformation.getAirportTo(), flightInformation.getDepartureDate(), flightInformation.getFlightDuration(), flightInformation.getPassengerCapacity(), flightInformation.getPrice());
		return "redirect:/admin/showAllFlights";
	}
	
	
	
	
	@GetMapping("/updateFlight/{id}")
	public String getUpdateFlightById(@PathVariable(name="id")int id,Model model,Flight flight)
	{
		try {
			Flight flightForUpdate = adminService.selectFlightById(id);
			model.addAttribute("flight", flightForUpdate);
			return "update";
		} catch (Exception e) {
			return "error";
		}
	}
	
	
	@PostMapping("/updateFlight/{id}")//it will be called when SUBMIT button is pressed
	public String postUpdateProductById(@PathVariable(name = "id")int id,Flight flight)
	{
		System.out.println(flight);
		System.out.println(id);		
		
		if(adminService.updateFlightById(id, flight.getAirportFromAndTo().iterator().next(), flight.getAirportFromAndTo().iterator().next(), flight.getDepartureDate(), flight.getFlightDuration(), flight.getPassengerCapacity())) {
			return "show-flight/{id}";
		}
		return "update";
	}
	
	
}
