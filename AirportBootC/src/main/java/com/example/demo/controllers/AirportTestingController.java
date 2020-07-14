package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.services.IAirportTestingService;


@Controller
public class AirportTestingController {

	@Autowired
	IAirportTestingService airService;
	
	@GetMapping("/test")
	public String getTest()
	{
		airService.testModelLayer();
		return "hello-page";
	}
	
	
}
