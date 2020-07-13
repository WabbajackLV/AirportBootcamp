package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Airport;
import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.services.IFlightService;

public class FlightServiceImpl implements IFlightService{
	
	@Autowired
	IFlightRepo flightRepo;
	
	@Override
	public boolean updateFlightById(int id, Airport apFrom, Airport apTo,Collection<BoardingPass> allBoardingPasses, Date departure, double duration, int capacity, int seatsTaken) {
		if(id > 0) {
			if(flightRepo.existsById(id)) {
				Flight flightToUpdate = flightRepo.findById(id).get();
				flightToUpdate.setAirportFrom(apFrom);
				flightToUpdate.setAirportTo(apTo);
				flightToUpdate.setAllBoardingPasses(allBoardingPasses);
				flightToUpdate.setDepartureDate(departure);
				flightToUpdate.setFlightDuration(duration);
				flightToUpdate.setPassengerCapacity(capacity);
				flightToUpdate.setSeatsTaken(seatsTaken);
				flightRepo.save(flightToUpdate);
				
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean updateFlightObjectById(int id, Flight flight) {
		if(id > 0) {
			if(flightRepo.existsById(id)) {
				Flight flightToUpdate = flightRepo.findById(id).get();
				flightToUpdate.setAirportFrom(flight.getAirportFrom());
				flightToUpdate.setAirportTo(flight.getAirportTo());
				flightToUpdate.setAllBoardingPasses(flight.getAllBoardingPasses());
				flightToUpdate.setDepartureDate(flight.getDepartureDate());
				flightToUpdate.setFlightDuration(flight.getFlightDuration());
				flightToUpdate.setPassengerCapacity(flight.getPassengerCapacity());
				flightToUpdate.setSeatsTaken(flight.getSeatsTaken());
				flightRepo.save(flightToUpdate);
				
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean deleteFlightById(int id) {
		if(id > 0) {
			if(flightRepo.existsById(id)) {
				flightRepo.deleteById(id);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean createNewFlight(Airport airportFrom, Airport airportTo, Date departureDate, double flightDuration, int passengerCapacity) {
		if(flightRepo.existsByAirportFromAndAirportToAndDepartureDateAndFlightDurationAndPassengerCapacity(airportFrom, airportTo, departureDate, flightDuration, passengerCapacity)) {
			return false;
		}
		Flight newFlight = new Flight(airportFrom, airportTo, departureDate, flightDuration, passengerCapacity);
		flightRepo.save(newFlight);
		return true;
	}
	
	@Override 
	public ArrayList<Flight> flightsInAirportInDay(Airport airportFrom, Date departureDate) {
		ArrayList<Flight> flightsInDate = flightRepo.findAllByAirportFromAndDepartureDate(airportFrom, departureDate);
		return flightsInDate;
	}
	
	
}