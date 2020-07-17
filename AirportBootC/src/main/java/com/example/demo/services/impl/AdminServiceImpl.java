package com.example.demo.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Airport;
import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.repos.IAdminRepo;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.services.IAdminService;
import com.example.demo.services.IFlightService;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	IAdminRepo adminRepo;
	
	@Autowired
	IFlightService flightService;
	
	@Autowired
	IFlightRepo flightRepo;


	@Override
	public Flight selectFlightById(int id) throws Exception{
		return flightService.selectOneFlightById(id);
	}
	
	/*
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
	*/
	
	/*
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
	*/
	/*
	@Override
	public boolean updateFlightById(int id,Airport airportFrom, Airport airportTo,Collection<BoardingPass> allBoardingPasses, Date departureDate, double flightDuration,
			int passengerCapacity, int seatsTaken ) {
		if(id > 0 )
		{
			for(int i=0;i<adminRepo.allFlights.size();i++)
			{
				if(adminRepo.allFlights.get(i).getF_ID() == id)
				{
					adminRepo.allFlights.get(id).setAirportFrom(airportFrom);
					adminRepo.allFlights.get(id).setAirportTo(airportTo);
					adminRepo.allFlights.get(id).setDepartureDate(departureDate);
					adminRepo.allFlights.get(id).setFlightDuration(flightDuration);
					adminRepo.allFlights.get(id).setPassengerCapacity(passengerCapacity);
		
					return true;
				}
			}
		}
			
		return false;
	}
	*/

	@Override
	public boolean deleteFlightById(int id) {
		if(id > 0 )
		{
			for(int i=0;i<IAdminRepo.allFlights.size();i++)
			{
				if(IAdminRepo.allFlights.get(i).getF_ID() == id)
				{
					IAdminRepo.allFlights.remove(id);
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

	@Override
	public boolean insertFlightByObject(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertFlight(Airport airportFrom, Airport airportTo, LocalDateTime departureDate, double flightDuration,
			int passengerCapacity) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean updateFlightById(int id, Airport airportFrom, Airport airportTo, LocalDateTime departureDate, double flightDuration,
			int passengerCapacity) {
		System.out.println("ID-" + id);
		if(flightRepo.existsById(id)) {
			Flight updateFlight = flightRepo.findById(id).get();
			Collection<Airport> toAndFrom = new ArrayList<Airport>();
			toAndFrom.add(airportFrom);
			toAndFrom.add(airportTo);
			
			updateFlight.setAirportFromAndTo(toAndFrom);
			updateFlight.setDepartureDate(departureDate);
			updateFlight.setFlightDuration(flightDuration);
			updateFlight.setPassengerCapacity(passengerCapacity);
			flightRepo.save(updateFlight);
			return true;
		}
		return false;
	}

	
}
