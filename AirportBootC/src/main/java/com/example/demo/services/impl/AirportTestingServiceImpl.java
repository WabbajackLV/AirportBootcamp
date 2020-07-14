package com.example.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Person;
import com.example.demo.models.RegisteredUser;
import com.example.demo.repos.IRegisteredUserRepo;
import com.example.demo.services.IAirportTestingService;



@Service
public class AirportTestingServiceImpl implements IAirportTestingService{

@Autowired
IRegisteredUserRepo regURepo;
	
	@Override
	public void testModelLayer() {

		Person p1=new Person("Marina","Rediko",18,27897893,"tratata@gmail.com");
		Person p2=new Person("Jim","TYUy",23,34234234,"hjhghjhg@gmail.com");
		Person p3=new Person("Usdf","Uklkj",78,67896789,"ghhhhh@gmail.com");
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
	
		RegisteredUser r1=new RegisteredUser();
		//RegisteredUser r1=new RegisteredUser("Jim","TYUy",23,34234234,"hjhghjhg@gmail.com",2);
		regURepo.save(r1);
		System.out.println(r1);
	}



}
