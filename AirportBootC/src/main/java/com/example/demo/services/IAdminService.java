package com.example.demo.services;

import java.util.Collection;
import java.util.Date;

import com.example.demo.models.Airport;
import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;

public interface IAdminService {

	//boolean insertFlight(Airport airportFrom, Airport airportTo,Date departureDate, double flightDuration,int passengerCapacity);

	//boolean updateFlightById(int id);

	boolean deleteFlightById(int id);

	boolean insertFlightByObject(Flight flight);
	
	void seeStatistics();

	Flight selectFlightById(int id) throws Exception;

	boolean insertFlight(Airport airportFrom, Airport airportTo, Date departureDate, double flightDuration,
			int passengerCapacity);

	boolean updateFlightById(int id, Airport airportFrom, Airport airportTo, Collection<BoardingPass> allBoardingPasses,
			Date departureDate, double flightDuration, int passengerCapacity, int seatsTaken);
	
}
