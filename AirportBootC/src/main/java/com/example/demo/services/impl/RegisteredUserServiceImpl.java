package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.IUserAuthorityRepo;
import com.example.demo.config.UserAuthorities;
import com.example.demo.models.Airport;
import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;
import com.example.demo.models.VipUser;
import com.example.demo.repos.IBoardingPassRepo;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.repos.IRegisteredUserRepo;
import com.example.demo.repos.IVipUserRepo;
import com.example.demo.services.IRegisteredUserService;

@Service
public class RegisteredUserServiceImpl implements IRegisteredUserService{

	@Autowired
	IRegisteredUserRepo regURepo;
	
	@Autowired
	IFlightRepo flightRepo;
	@Autowired 
	IBoardingPassRepo bPassRepo;
	@Autowired
	IVipUserRepo vipURepo;
	@Autowired
	PasswordEncoder passE;
	@Autowired
	IUserAuthorityRepo uAuthRepo;
	@Override
	public boolean register(String name, String surname, int age,int phoneNumber,String email,String password) {
		if(regURepo.existsByEmail(email)) {
		return false;
	}
		UserAuthorities auth=uAuthRepo.findByRoleName("user");
		RegisteredUser regU=new RegisteredUser(name,surname,age,phoneNumber,email,passE.encode(password),auth);
		
		regURepo.save(regU);
		return true;
	}
	
	@Override
	public ArrayList<Flight> selectAllFlights() {
		return (ArrayList<Flight>) flightRepo.findAll();
	}

	@Override
	public Flight selectOneFlightById(int id) throws Exception {
		if(id > 0 )
		{
			if(flightRepo.existsById(id))
			{
				return flightRepo.findById(id).get();		
			}
		}
		throw new Exception("Id is not correct and there is not product in the system");
	}
	
	
	@Override
	public ArrayList<BoardingPass> getAllBookingsByRUId(int id) throws Exception {
		if(id>0) {
			if(regURepo.existsById(id)) {
				RegisteredUser regUser = regURepo.findById(id).get();
				
				ArrayList<BoardingPass> purchasedBoardingPasses = bPassRepo.findByRegUser(regUser);
				 return purchasedBoardingPasses;
			}
		}
		throw new Exception("There is no customer with specific id in the System");
	}
	
	@Override 
	public boolean bookFlight(int id, Flight flight) {
		if(id > 0) {
			if(regURepo.existsById(id)) {
				RegisteredUser user = regURepo.findById(id).get();
				if(bPassRepo.existsByFlightAndRegUser(flight, user)) {
					return false;
				}
				BoardingPass newPass = new BoardingPass(flight, user);
				bPassRepo.save(newPass);
				
				user.setPoints(user.getPoints() + (flight.getPrice()/10));
				if(user.getPoints() >= 1000) {
					VipUser upgradeUser = new VipUser(user);

					vipURepo.save(upgradeUser);

				}regURepo.save(user);
				
				return true;
			}
			
		}
		return false;
	}
	
	
	

	/*
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
	*/
	
	@Override
	public boolean getBoardingPass(BoardingPass bPass) {
		return false;
		
		
	}

	@Override
	public boolean bookFlight(Collection<BoardingPass> purchasedBoardingPasses, int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RegisteredUser selectOneRegisteredUserById(int id) throws Exception {
		if(id>0) {
			if(regURepo.existsById(id)) {
				return regURepo.findById(id).get();
			}
			
		}
		throw new Exception("There is no registered user with specific id in the System");
	}

	
	}

