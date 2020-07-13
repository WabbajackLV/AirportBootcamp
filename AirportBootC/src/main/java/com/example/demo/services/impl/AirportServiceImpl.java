package com.example.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repos.IAirportRepo;
import com.example.demo.services.IAirportService;

@Service
public class AirportServiceImpl implements IAirportService{
	
	@Autowired
	IAirportRepo airRepo;
	
	
	
	
	

}
