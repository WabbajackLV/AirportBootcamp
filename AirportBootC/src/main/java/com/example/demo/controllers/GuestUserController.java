package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.RegisteredUser;
import com.example.demo.services.IBoardingPassService;
import com.example.demo.services.IFlightService;
import com.example.demo.services.IRegisteredUserService;

@Controller
public class GuestUserController {

	@Autowired
	IRegisteredUserService regUService;
	@Autowired
	IFlightService flightService;
	@Autowired
	IBoardingPassService boardPService;
	
	@GetMapping("/")
	public String showHome(Model model) {
		return "index";
	}
	
	@GetMapping("/registration_form")//localhost:8080/registeredUser/register
	public String getRegister(Model model)//Its empty customer
	{
		RegisteredUser regU=new RegisteredUser();
		model.addAttribute("regU", regU);
		return"registration_form";//register.html
	}
	
	@PostMapping("/save")
	public String postRegister(@Valid RegisteredUser regU, Model model,BindingResult result)
	{
		System.out.println(regU);
		if(result.hasErrors()) {
			return "registration_form";
		}
		model.addAttribute("regU", regU);
		regUService.register(regU.getName(),regU.getSurname(),regU.getAge(),regU.getPhoneNumber(),regU.getEmail(),regU.getPassword());
		return "display_form";
	}
	
}
