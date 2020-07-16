package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.config.IUserAuthorityRepo;
import com.example.demo.config.UserAuthorities;
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

@SpringBootApplication
public class AirportBootCApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportBootCApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(IRegisteredUserRepo regURepo,IAdminRepo adminRepo,IAirportRepo airRepo,IFlightRepo flightRepo,IUserAuthorityRepo uAuthRepo,PasswordEncoder password) {
		return (args) ->
		{
			Person p1=new Person("Msfd","Yuiuy",18,27897893,"tratata@gmail.com");
			Person p2=new Person("Jim","TYUy",23,24234234,"hjhghjhg@gmail.com");
			Person p3=new Person("Usdf","Uklkj",78,67896789,"ghhhhh@gmail.com");
			
			System.out.println(p1.toString());
			System.out.println(p2.toString());
			System.out.println(p3.toString());
		
			UserAuthorities adminAuth=new UserAuthorities("admin");
			uAuthRepo.save(adminAuth);
			UserAuthorities userAuth=new UserAuthorities("user");
			
			uAuthRepo.save(userAuth);
			
			
			RegisteredUser r1=new RegisteredUser("Michael","Tomson",23,27893789,"admin@gmail.com",password.encode("123"),adminAuth);
			UserAuthorities auth1=uAuthRepo.findByRoleName("admin");
			auth1.addUserToRole(r1);
			uAuthRepo.save(auth1);
			
			regURepo.save(r1);
			System.out.println(r1);
			
			
			RegisteredUser r2=new RegisteredUser("Lili","Coal",14,27892789,"lili@gmail.com",password.encode("123"),userAuth);
			UserAuthorities auth=uAuthRepo.findByRoleName("user");
			auth.addUserToRole(r2);
			uAuthRepo.save(auth);
			regURepo.save(r2);
			
			Admin a1=new Admin("Alex","Ray",34,26786789,"alex@gmail.com");
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
			Airport air4 = new Airport(Countries.Finland,4);
			airRepo.save(air4);
			Airport air5=new Airport(Countries.Poland,5);
			airRepo.save(air5);
			//System.out.println(air2);
			
			Flight f1=new Flight(new ArrayList<>(Arrays.asList(air3,air2)),null,1.5,77,90.9);
			flightRepo.save(f1);
			System.out.println(f1);
			air3.getFlights().add(f1);
			airRepo.save(air3);
			air2.getFlights().add(f1);
			airRepo.save(air2);
			
			Flight f2=new Flight(new ArrayList<>(Arrays.asList(air4,air5)),null,2.5,100,50);
			flightRepo.save(f2);
			System.out.println(f2);
			air4.getFlights().add(f2);
			airRepo.save(air4);
			air5.getFlights().add(f2);
			airRepo.save(air5);
		};
}
}
