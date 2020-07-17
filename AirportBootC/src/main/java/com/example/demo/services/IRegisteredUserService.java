package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collection;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;

public interface IRegisteredUserService {

			
	//see all flights
	ArrayList<Flight> selectAllFlights();
	Flight selectOneFlightById(int id)throws Exception;
	
	
	ArrayList<BoardingPass> getAllBookingsByRUId(int id) throws Exception;
	
	ArrayList<Flight> getAllFlightsByRUId(int id) throws Exception;
	
	boolean bookFlight(Collection<BoardingPass> purchasedBoardingPasses,int id )throws Exception;
	

	boolean getBoardingPass(BoardingPass bPass);

	int bookFlightCustEmail(String email)throws Exception;
	
	boolean bookFlight(int id, Flight flight,Collection<BoardingPass> purchasedBoardingPasses,RegisteredUser regU);

	RegisteredUser selectOneRegisteredUserById(int id)throws Exception;

	boolean register(String name, String surname, int age, int phoneNumber, String email,String password);
	boolean buyFlights(Collection<Flight> purchasedFlights, int id) throws Exception;

	
}
