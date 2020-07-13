package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.repos.IRegisteredUserRepo;
import com.example.demo.services.IRegisteredUserService;

@Service
public class RegisteredUserServiceImpl implements IRegisteredUserService{

	@Autowired
	IRegisteredUserRepo regURepo;
	
	@Autowired
	IFlightRepo flightRepo;
	
	
	@Override
	public ArrayList<Flight> getAllBookingsByRUId(int id) throws Exception {
		if(id>0) {
			if(flightRepo.existsById(id)) {
				RegisteredUser regU = regURepo.findById(id).get();
				
				ArrayList<Flight> purchasedFlight = flightRepo.findByRegisteredUser(regU);
				 return purchasedFlight;
			}
		}
		throw new Exception("There is no customer with specific id in the System");
	}

	@Override
	public boolean bookFlight(Collection<Flight> purchasedFlights, int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getBoardingPass() {
		// TODO Auto-generated method stub
		
	}

}
