package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.IFlightService;
import com.example.demo.services.IRegisteredUserService;

@Controller
@RequestMapping("/registeredUser")
public class RegisteredUserController {
	
	@Autowired
	IRegisteredUserService regUService;
	@Autowired
	IFlightService flightService;
	
	@GetMapping("/showMyBookings/{id}")
	public String getShowMyBookingsByRegUId(@PathVariable(name="id")int id,Model model)
	{
		try {
			model.addAttribute("innerObjectProd",regUService.getAllBookingsByRUId(id));
			return "show-all-bookings";
			}
		catch(Exception e)
			{
				return "error";
			}
	}
	
}
