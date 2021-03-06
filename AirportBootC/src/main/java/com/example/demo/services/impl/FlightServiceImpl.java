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
import com.example.demo.repos.IAirportRepo;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.repos.IRegisteredUserRepo;
import com.example.demo.services.IFlightService;

@Service
public class FlightServiceImpl implements IFlightService{
	
	
	
	
	@Autowired
	IFlightRepo flightRepo;
	
	@Autowired
	IAirportRepo airRepo;
	@Autowired
	IRegisteredUserRepo regURepo;
	
	@Override
	public boolean updateFlightById(int id, Airport apFrom, Airport apTo,Collection<BoardingPass> allBoardingPasses, LocalDateTime departure, double duration, int capacity, int seatsTaken) {
		if(id > 0) {
			if(flightRepo.existsById(id)) {
				Flight flightToUpdate = flightRepo.findById(id).get();
				
				Collection<Airport> newCollection = new ArrayList<Airport>();
				newCollection.add(apFrom);
				newCollection.add(apTo);
				flightToUpdate.setAirportFromAndTo(newCollection);
				
				flightToUpdate.setBoardingPasses(allBoardingPasses);
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
		
				flightToUpdate.setAirportFromAndTo(flight.getAirportFromAndTo());
				
				flightToUpdate.setBoardingPasses(flight.getBoardingPasses());
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
	public ArrayList<Flight> selectAllFlights(){
		ArrayList<Flight> allFlights = (ArrayList<Flight>) flightRepo.findAll();
		return allFlights;
	}
	
	@Override
	public boolean createNewFlight(Airport airportFrom, Airport airportTo, LocalDateTime departureDate, double flightDuration, int passengerCapacity, double price) {
		Airport air1 = airRepo.findByAirportCode(airportFrom.getAirportCode());
		Airport air2 = airRepo.findByAirportCode(airportTo.getAirportCode());
		
		
		Collection<Airport> tempA = new ArrayList<Airport>();
		//ArrayList<Airport> tempA = new ArrayList<>();
		tempA.add(air1);
		tempA.add(air2);
		System.out.println("Departure date ==>" + departureDate);
		System.out.println("TEMP_A" + tempA);
		Flight newFlight = new Flight(tempA, departureDate, flightDuration, passengerCapacity, price);
		air1.getFlights().add(newFlight);
		air2.getFlights().add(newFlight);
		flightRepo.save(newFlight);
		airRepo.save(air1);
		airRepo.save(air2);
		System.out.println("Repo ==> " + flightRepo.findAll());
		return true;
	}
	
	
	@Override 
	public ArrayList<Flight> flightsInAirportInDay(Airport airportFrom, LocalDateTime departureDate) {
		//ArrayList<Flight> flightsInDate = flightRepo.findAllByAirportFromAndDepartureDate(airportFrom, departureDate);
		//return flightsInDate;
		return null;
	}
	
	@Override 
	public ArrayList<Flight> allFlightsFromAirportToAirport(Airport airportFrom, Airport airportTo){
		//ArrayList<Flight> foundFlights = flightRepo.findByAirportFromAndAirportTo(airportFrom, airportTo);
		//return foundFlights;
		return null;
	}




	@Override
	public Flight selectOneFlightById(int id) throws Exception {
		if(id > 0 )
		{
			if(flightRepo.existsById(id))
			{
				return flightRepo.findById(id).get();		
			}
		}
		throw new Exception("Id is not correct and there is not product in the system");
	}

	@Override
	public Flight addOneFlightById(int id) {
	
		return flightRepo.findById(id).get();	
	}

	
}
