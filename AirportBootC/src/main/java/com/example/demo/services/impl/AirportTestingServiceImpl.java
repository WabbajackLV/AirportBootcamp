package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enums.Countries;
import com.example.demo.models.Admin;
import com.example.demo.models.Airport;
import com.example.demo.models.Flight;
import com.example.demo.models.Person;
import com.example.demo.models.RegisteredUser;
import com.example.demo.repos.IAdminRepo;
import com.example.demo.repos.IAirportRepo;
import com.example.demo.repos.IFlightRepo;
import com.example.demo.repos.IRegisteredUserRepo;
import com.example.demo.services.IAirportTestingService;



@Service
public class AirportTestingServiceImpl implements IAirportTestingService{

@Autowired
IRegisteredUserRepo regURepo;
@Autowired
IAdminRepo adminRepo;
@Autowired
IAirportRepo airRepo;
@Autowired
IFlightRepo flightRepo;
	
	@Override
	public void testModelLayer() {

		Person p1=new Person("Marina","Rediko",18,27897893,"tratata@gmail.com");
		Person p2=new Person("Jim","TYUy",23,24234234,"hjhghjhg@gmail.com");
		Person p3=new Person("Usdf","Uklkj",78,67896789,"ghhhhh@gmail.com");
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
	
		RegisteredUser r1=new RegisteredUser("Mich","Tale",23,27893789,"mich@gmail.com",34,null,null);
		//RegisteredUser r1=new RegisteredUser("Jim","TYUy",23,34234234,"hjhghjhg@gmail.com",2);
		regURepo.save(r1);
		System.out.println(r1);
		
		Admin a1=new Admin("Alex","Loiop",34,26786789,"alex@gmail.com");
		adminRepo.save(a1);
		System.out.println(a1);
		System.out.println(a1);
		
		/*Airport air1=new Airport(Countries.Belgium,12);
		airRepo.save(air1);
		System.out.println(air1);*/
		
		
		Airport air3 = new Airport(Countries.Belarus,1);
		airRepo.save(air3);
		Airport air2=new Airport(Countries.Albania,22);
		airRepo.save(air2);
		//System.out.println(air2);
		
		Flight f1=new Flight(new ArrayList<>(Arrays.asList(air3,air2)),null,1.5,77,90.9);
		flightRepo.save(f1);
		System.out.println(f1);
		air3.getFlights().add(f1);
		airRepo.save(air3);
		air2.getFlights().add(f1);
		airRepo.save(air2);
	}



}
