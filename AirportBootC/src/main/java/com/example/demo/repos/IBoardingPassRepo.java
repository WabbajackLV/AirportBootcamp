package com.example.demo.repos;

import java.util.ArrayList;


import org.springframework.data.repository.CrudRepository;


import com.example.demo.models.BoardingPass;

import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;

public interface IBoardingPassRepo extends CrudRepository<BoardingPass, Integer>{

	ArrayList<BoardingPass> findByRegUser(RegisteredUser regUser);


	BoardingPass findByFlight(Flight flight);

	boolean existsByFlightAndRegUser(Flight flight, RegisteredUser regUser);
}
