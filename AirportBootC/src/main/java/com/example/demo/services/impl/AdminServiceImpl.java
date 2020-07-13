package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.demo.models.Airport;
import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.services.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
	
	ArrayList<Flight> allFlights = new ArrayList<>();

	@Override
	public Flight selectFlightById(int id) throws Exception{
		if(id > 0 )
		{
			for(int i=0;i<allFlights.size();i++)
			{
				if(allFlights.get(i).getF_ID() == id)
					return allFlights.get(i);
				
			}
		}
		throw new Exception("There is no Flight with this id in the system");
	}
	
	
	@Override
	public boolean insertFlight( Airport airportFrom, Airport airportTo, Date departureDate,
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
		
		allFlights.add(new Flight(airportFrom, airportTo,departureDate, flightDuration, passengerCapacity));
		return true;
		
	}
	
	@Override
	public boolean insertFlightByObject(Flight flight) {
		for (Flight fl:allFlights)
		{
			if(fl.getAirportFrom().equals(flight.getAirportFrom()) && 
					fl.getAirportTo().equals(flight.getAirportTo())&& 
					fl.getDepartureDate().equals(flight.getDepartureDate())&&
					fl.getFlightDuration() == flight.getFlightDuration()&&
					fl.getPassengerCapacity()==flight.getPassengerCapacity())
			return false;
		}
		allFlights.add(new Flight(flight.getAirportFrom(),flight.getAirportTo(),flight.getDepartureDate(),flight.getFlightDuration(),flight.getPassengerCapacity()));
		return true;
	}

	@Override
	public boolean updateFlightById(int id,Airport airportFrom, Airport airportTo,Collection<BoardingPass> allBoardingPasses, Date departureDate, double flightDuration,
			int passengerCapacity, int seatsTaken ) {
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

	@Override
	public void seeStatistics() {
		// TODO Auto-generated method stub
		
	}

	
}
