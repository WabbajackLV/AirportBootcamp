package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.example.demo.models.Airport;
import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;

public interface IFlightService {

	boolean updateFlightById(int id, Airport apFrom, Airport apTo, Collection<BoardingPass> allBoardingPasses, LocalDateTime departure, double duration, int capacity, int seatsTaken);

	boolean updateFlightObjectById(int id, Flight flight);

	boolean deleteFlightById(int id);


	ArrayList<Flight> flightsInAirportInDay(Airport airportFrom, LocalDateTime departureDate);

	ArrayList<Flight> allFlightsFromAirportToAirport(Airport airportFrom, Airport airportTo);

	boolean createNewFlight(Airport airportFrom, Airport airportTo, LocalDateTime departureDate, double flightDuration,int passengerCapacity, double price);

	ArrayList<Flight> selectAllFlights();





}
