package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collection;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;

public interface IRegisteredUserService {

	ArrayList<BoardingPass> getAllBookingsByRUId(int id) throws Exception;
	
	boolean bookFlight(Collection<BoardingPass> purchasedBoardingPasses,int id )throws Exception;
	

	boolean getBoardingPass(BoardingPass bPass);

	boolean bookFlight(int id, Flight flight);

}
