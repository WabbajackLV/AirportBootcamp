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
import com.example.demo.services.IRegisteredUserService;

@Service
public class RegisteredUserServiceImpl implements IRegisteredUserService{

	@Autowired
	IRegisteredUserRepo regURepo;
	
	@Autowired
	IFlightRepo flightRepo;
	@Autowired 
	IBoardingPassRepo bPassRepo;
	
	
	@Override
	public ArrayList<BoardingPass> getAllBookingsByRUId(int id) throws Exception {
		if(id>0) {
			if(regURepo.existsById(id)) {
				RegisteredUser regU = regURepo.findById(id).get();
				
				ArrayList<BoardingPass> purchasedBoardingPasses = bPassRepo.findByRegisteredUser(regU);
				 return purchasedBoardingPasses;
			}
		}
		throw new Exception("There is no customer with specific id in the System");
	}
	

	@Override

	public boolean bookFlight(Collection<BoardingPass> purchasedBoardingPasses, int id) throws Exception {


		if(id>0)
		{
			if(regURepo.existsById(id))
			{
				RegisteredUser regU = regURepo.findById(id).get();

				for(BoardingPass bPass:purchasedBoardingPasses)
				{
				BoardingPass boardPass = bPassRepo.findByFlight(bPass.getFlight());
				boardPass.setRegUser(regU);
				bPassRepo.save(boardPass);
				return true;

				
				}
			}
		}
		throw new Exception("There is no registered user with specific id in the System");
	}

	
	@Override
	public void getBoardingPass() {
		
		
	}


}
