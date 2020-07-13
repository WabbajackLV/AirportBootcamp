package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collection;

import com.example.demo.models.Flight;

public interface IRegisteredUserService {

	ArrayList<Flight> getAllBookingsByRUId(int id) throws Exception;
	
	boolean bookFlight(Collection<Flight> purchasedFlights,int id )throws Exception;
	
	void getBoardingPass();
}
