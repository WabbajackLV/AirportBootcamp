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

import com.example.demo.models.Flight;
import com.example.demo.services.IAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IAdminService adminService;

	
	@GetMapping("/newFlight")//url address -> localhost:8080/admin/newFlight
	public String getNewFlight(Flight flight)
	{
		return "new-flight";//new-flight.html
		
	}
	
	@PostMapping("/newFlight")//it will be called when SUBMIT button is pressed
	public String postInsertOneProduct(@Valid Flight flight, BindingResult result)
	{
		if(result.hasErrors()) {
			return "new-flight";
		}
		adminService.insertFlightByObject(flight);
		return "redirect:/guest/showAllFlights";
	}
	
	/*@GetMapping("/updateFlight/{id}")
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
		
		adminService.updateFlightById(id, flight);
	}
	*/
	
}
