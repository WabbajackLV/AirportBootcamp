package com.example.demo.services;

import com.example.demo.enums.Countries;
import com.example.demo.models.Airport;

public interface IAirportService {

	boolean insertNewAirport(Countries country, int number);

	boolean insertNewAirportByObject(Airport airport);

	boolean deleteByAirportCode(String airportCode);

}
