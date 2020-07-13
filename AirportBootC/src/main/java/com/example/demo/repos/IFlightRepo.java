package com.example.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Flight;
import com.example.demo.models.RegisteredUser;

public interface IFlightRepo extends CrudRepository<Flight, Integer>{

	ArrayList<Flight> findByRegisteredUser(RegisteredUser regU);

}
