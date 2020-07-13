package com.example.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Admin;
import com.example.demo.models.Flight;

public interface IAdminRepo extends CrudRepository<Admin,Integer>{
	ArrayList<Flight> allFlights = new ArrayList<>();
}
