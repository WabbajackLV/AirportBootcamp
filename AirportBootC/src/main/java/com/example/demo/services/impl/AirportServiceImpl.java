package com.example.demo.services.impl;

import java.lang.module.FindException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enums.Countries;
import com.example.demo.models.Airport;
import com.example.demo.repos.IAirportRepo;
import com.example.demo.services.IAirportService;

@Service
public class AirportServiceImpl implements IAirportService{
	
	@Autowired
	IAirportRepo airRepo;
	
	
	//TODO getAllAirports
	@Override
	public ArrayList<Airport> getAllAirports(){
		return (ArrayList<Airport>) airRepo.findAll();
	}
	
	@Override
	public boolean insertNewAirport(Countries country, int number) {
		if(airRepo.existsByCountryAndNumber(country, number)) {
			return false;
		}
		airRepo.save(new Airport(country, number));
		return true;
	}
	
	@Override
	public boolean insertNewAirportByObject(Airport airport) {
		if(airRepo.existsByAirportCode(airport.getAirportCode())) {
			return false;
		}
		airRepo.save(airport);
		return true;
	}
	
	
	@Override
	public boolean deleteByAirportCode(String airportCode) {
		if(airRepo.existsByAirportCode(airportCode)) {
			airRepo.deleteByAirportCode(airportCode);
			return true;
		}
		return false;
	}
	
	
	

}
