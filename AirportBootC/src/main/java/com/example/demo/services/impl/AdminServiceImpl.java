package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Airport;
import com.example.demo.models.Flight;
import com.example.demo.models.Product;
import com.example.demo.repos.IAdminRepo;
import com.example.demo.services.IAdminService;

public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	IAdminRepo adminRepo;
	
	@Autowired
	IFlightRepo flightRepo;
	
	ArrayList<Flight> allFlights = new ArrayList<>();

	@Override
	public void insertFlight(Airport airportFrom, Airport airportTo, Date departureDate, double flightDuration,
			int passengerCapacity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateFlightById(int id) {
		if(id > 0 )
		{
			for(int i=0;i<allFlights.size();i++)
			{
				if(allFlights.get(i).getF_ID() == id)
				{
					allFlights.get(i).setAirportFrom(airportFrom);
					return true;
				}
			}
		}
			
		return false;
	}

	@Override
	public boolean deleteFlightById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
