package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Airport;
import com.example.demo.models.Flight;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.services.IHelper;
import com.example.demo.utils.FlightInformation;
@Service
public class HelperImpl implements IHelper{
	@Autowired
	IFlightRepo flightRepo;
	
	
	@Override
	public ArrayList<FlightInformation> converterHelper() {
		ArrayList<FlightInformation> tempArray = new ArrayList<FlightInformation>();
		ArrayList<Flight> flightsTemp = (ArrayList<Flight>) flightRepo.findAll();
		
		
		
		
		
		for(int i = 0; i < flightsTemp.size(); i++) {
			
			Iterator<Airport> iterObj = flightsTemp.get(i).getAirportFromAndTo().iterator();
			
			
			Airport airportFrom = iterObj.next();
			Airport airportTo = iterObj.next();
			
			tempArray.add(new FlightInformation(flightsTemp.get(i).getF_ID(), airportFrom, airportTo, flightsTemp.get(i).getPrice(), flightsTemp.get(i).getDepartureDate(), flightsTemp.get(i).getFlightDuration(), flightsTemp.get(i).getPassengerCapacity(), flightsTemp.get(i).getSeatsTaken()));
		}
		
		return tempArray;
		
	}
	
	@Override
	public FlightInformation converterHelperForOne(Flight flight) {
		Iterator<Airport> iterObj = flight.getAirportFromAndTo().iterator();
		
		
		Airport airportFrom = iterObj.next();
		Airport airportTo = iterObj.next();
		FlightInformation newInfo = new FlightInformation(flight.getF_ID(), airportFrom, airportTo, flight.getPrice(), flight.getDepartureDate(), flight.getFlightDuration(), flight.getPassengerCapacity(), flight.getSeatsTaken());
		
			return newInfo;	
		}
		
		
	
}
