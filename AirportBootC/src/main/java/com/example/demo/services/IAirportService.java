package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.enums.Countries;
import com.example.demo.models.Airport;

public interface IAirportService {

	boolean insertNewAirport(Countries country, int number);

	boolean insertNewAirportByObject(Airport airport);

	boolean deleteByAirportCode(String airportCode);

	ArrayList<Airport> getAllAirports();

}
