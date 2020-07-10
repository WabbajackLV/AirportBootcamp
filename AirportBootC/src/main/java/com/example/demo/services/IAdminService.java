package com.example.demo.services;

import java.util.Date;

import com.example.demo.models.Airport;

public interface IAdminService {

	void insertFlight(Airport airportFrom, Airport airportTo,Date departureDate, double flightDuration,int passengerCapacity);

	boolean updateFlightById(int id);

	boolean deleteFlightById(int id);
	
}
