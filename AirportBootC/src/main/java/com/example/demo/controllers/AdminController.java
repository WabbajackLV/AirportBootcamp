package com.example.demo.controllers;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.validation.Valid;

import org.apache.catalina.LifecycleListener;
import org.hibernate.cfg.FkSecondPass;
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
import com.example.demo.services.IHelper;
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
	
	@Autowired
	IHelper helperService;

	@GetMapping("/showAllFlightsAdmin")
	public String getShowAllFlightsAdmin(Model model) {
		model.addAttribute("innerObject", helperService.converterHelper());
		return "show-all-flights-admin";
	}
	
	/*
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
	*/
	
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
		return "redirect:/admin/showAllFlightsAdmin";
	}
	
	
	
	
	@GetMapping("/updateFlight/{id}")
	public String getUpdateFlightById(@PathVariable(name="id")int id,Model model,FlightInformation	flightInformation)
	{
		try {
	
			Flight flightForUpdate = adminService.selectFlightById(id);
			System.out.println("flightFroUpdate ==> " + flightForUpdate.getF_ID());
			Iterator<Airport> newIter = flightForUpdate.getAirportFromAndTo().iterator();
			FlightInformation newInfo = new FlightInformation(flightForUpdate.getF_ID(), newIter.next(), newIter.next(), flightInformation.getPrice(), flightInformation.getDepartureDate(), flightInformation.getFlightDuration(), flightInformation.getPassengerCapacity(), flightInformation.getSeatsTaken());
			model.addAttribute("flightInformation", newInfo);
			model.addAttribute("airports", airportService.getAllAirports());
			System.out.println("toString - " + newInfo.toString());
			return "update-flight";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	
	@PostMapping("/updateFlight/{id}")//it will be called when SUBMIT button is pressed
	public String postUpdateFlightById(@PathVariable(name = "id")int id, FlightInformation	flightInformation)
	{
		System.out.println(flightInformation);
		System.out.println(adminService.updateFlightById(flightInformation.getF_ID(),flightInformation.getAirportFrom(), flightInformation.getAirportTo(), flightInformation.getDepartureDate(), flightInformation.getFlightDuration(), flightInformation.getPassengerCapacity()));
		if(adminService.updateFlightById(id,flightInformation.getAirportFrom(), flightInformation.getAirportTo(), flightInformation.getDepartureDate(), flightInformation.getFlightDuration(), flightInformation.getPassengerCapacity())) {
			return "redirect:/registeredUser/showAllFlights/" + id;
		}
		return "update-flight";
	}
	
	
	@GetMapping("/deleteFlight/{id}")
	public String getDeleteFlightById(@PathVariable(name = "id") int id, Model model, Flight flight) {
		System.out.println("ID IN GETMAPPING" + id);
		adminService.deleteFlightById(id);
		model.addAttribute("innerObject", flightService.selectAllFlights());
		return "show-all-flights-admin";
		
		
	}
	
	
	@GetMapping("/showAllAirports")
	public String getShowAllAirports(Model model) {
		model.addAttribute("innerObject", airportService.getAllAirports());
		return "show-all-airports";
	}
	
	@GetMapping("/newAirport")
	public String getNewAirport(Airport airport) {
		
		return "new-airport";
	}
	
	@PostMapping("/newAirport")
	public String postNewAirport(@Valid Airport airport, BindingResult result) {
		/*
		if(result.hasErrors()) {
			return "insert-one-product-page";
		}
		*/
		airportService.insertNewAirport(airport.getCountry(), airport.getNumber());
		return "redirect:/admin/showAllAirports";
	}
	
	@GetMapping("/deleteAirport/{id}")
	public String getDeleteAirport(@PathVariable(name = "id") int id, Model model, Airport airport) {

		airportService.deleteByAirportCode(airport.getAirportCode());
		model.addAttribute("innerObject", airportService.getAllAirports());
		return "show-all-airports";
	}
	
	
	
	
}
