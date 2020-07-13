package com.example.demo.repos;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Airport;
import com.example.demo.models.Flight;

public interface IFlightRepo extends CrudRepository<Flight, Integer>{

	boolean existsByAirportFromAndAirportToAndDepartureDateAndFlightDurationAndPassengerCapacity(Airport airportFrom, Airport airportTo, Date departureDate, double flightDuration, int passengerCapacity);

	ArrayList<Flight> findAllByAirportFromAndDepartureDate(Airport airportFrom, Date departureDate);

}
