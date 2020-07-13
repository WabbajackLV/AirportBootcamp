package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.example.demo.models.Airport;
import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;

public interface IFlightService {

	boolean updateFlightById(int id, Airport apFrom, Airport apTo, Collection<BoardingPass> allBoardingPasses, Date departure, double duration, int capacity, int seatsTaken);

	boolean updateFlightObjectById(int id, Flight flight);

	boolean deleteFlightById(int id);

	boolean createNewFlight(Airport airportFrom, Airport airportTo, Date departureDate, double flightDuration, int passengerCapacity);

	ArrayList<Flight> flightsInAirportInDay(Airport airportFrom, Date departureDate);





}