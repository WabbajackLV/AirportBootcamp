package com.example.demo.repos;

import java.util.ArrayList;
import java.util.Date;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Airport;
import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;

public interface IFlightRepo extends CrudRepository<Flight, Integer>{


	ArrayList<Flight> findByRegU(RegisteredUser regUser);

	//ArrayList<Flight> findByRegUserEmail(String email);


	
	//ArrayList<Flight> findByRegisteredUser(RegisteredUser regU);
	//ArrayList<Flight> findAllByAirportFromAndDepartureDate(Airport airportFrom, Date departureDate);

	//ArrayList<Flight> findByAirportFromAndAirportTo(Airport airportFrom, Airport airportTo);

	//Flight findByAirportFromAndDepartureDate(Airport airportFrom, Date departureDate);
	


}
