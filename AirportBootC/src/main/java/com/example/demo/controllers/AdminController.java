package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Flight;
import com.example.demo.repos.IAdminRepo;
import com.example.demo.repos.IAirportRepo;
import com.example.demo.repos.IFlightRepo;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IAdminRepo adminRepo;
	
	@Autowired
	IFlightRepo flightRepo;
	
	@Autowired
	IAirportRepo airportRepo;
	
	@GetMapping("/newFlight")
	public String getNewFlight(Flight flight)
	{
		return "new-flight";//new-flight.html
		
	}
	
	
}
