package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Airport;
import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.repos.IAdminRepo;
import com.example.demo.repos.IAirportRepo;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.services.IAdminService;

public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	IAdminRepo adminRepo;
	
	@Autowired
	IFlightRepo flightRepo;
	
	@Autowired
	IAirportRepo airportRepo;
	
	
	ArrayList<Flight> allFlights = new ArrayList<>();

	@Override
	public boolean insertFlight(int id, Airport airportFrom, Airport airportTo, BoardingPass boardingPass, Date departureDate,
			double flightDuration, int passengerCapacity) {
		for (int i =0; i<allFlights.size();i++)
		{
			if(allFlights.get(i).getAirportFrom().equals(airportFrom) && 
					allFlights.get(i).getAirportTo().equals(airportTo)&& 
					allFlights.get(i).getDepartureDate().equals(departureDate)&&
					allFlights.get(i).getFlightDuration() == flightDuration &&
					allFlights.get(i).getPassengerCapacity()== passengerCapacity)
			return false;
		}
		
		allFlights.add(new Flight(id ,airportFrom, airportTo,boardingPass, departureDate, flightDuration, passengerCapacity));
		return true;
		
	}

	@Override
	public boolean updateFlightById(int id,Airport airportFrom, Airport airportTo, Date departureDate, double flightDuration,
			int passengerCapacity ) {
		if(id > 0 )
		{
			for(int i=0;i<allFlights.size();i++)
			{
				if(allFlights.get(i).getF_ID() == id)
				{
					allFlights.get(id).setAirportFrom(airportFrom);
					allFlights.get(id).setAirportTo(airportTo);
					allFlights.get(id).setDepartureDate(departureDate);
					allFlights.get(id).setFlightDuration(flightDuration);
					allFlights.get(id).setPassengerCapacity(passengerCapacity);
		
					return true;
				}
			}
		}
			
		return false;
	}

	@Override
	public boolean deleteFlightById(int id) {
		if(id > 0 )
		{
			for(int i=0;i<allFlights.size();i++)
			{
				if(allFlights.get(i).getF_ID() == id)
				{
					allFlights.remove(id);
					return true;
				}
			}
		}
		return false;
	}
}
