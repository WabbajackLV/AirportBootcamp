package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.repos.IBoardingPassRepo;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.repos.IRegisteredUserRepo;
import com.example.demo.services.IBoardingPassService;
@Service
public class BoardingPassServiceImpl implements IBoardingPassService {

	@Autowired
	IRegisteredUserRepo regURepo;
	@Autowired
	IFlightRepo flightRepo;
	@Autowired 
	IBoardingPassRepo bPassRepo;
	@Override
	
	public Collection<BoardingPass> getAllBookingsByRUId(int id)throws Exception {
		if(id>0) {
			if(regURepo.existsById(id)) {
				RegisteredUser regUser = regURepo.findById(id).get();
				
				Collection<BoardingPass> purchasedBoardingPasses = bPassRepo.findByRegUser(regUser);
				 return purchasedBoardingPasses;
			}
		}
		throw new Exception("There is no customer with specific id in the System");
	}
	@Override
	public Flight getFlightByBoardPassId(int id) {
		if(id>0) {
			if(bPassRepo.existsById(id)) {
				//Flight flight = bPassRepo.getFlight
			}
		}
		return null;
	}

}
