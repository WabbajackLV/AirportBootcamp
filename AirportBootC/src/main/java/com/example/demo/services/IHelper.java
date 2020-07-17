package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.models.Flight;
import com.example.demo.utils.FlightInformation;

public interface IHelper {
	
	
	ArrayList<FlightInformation> converterHelper();

	FlightInformation converterHelperForOne(Flight flight);

	//FlightInformation converterHelperForOne(ArrayList<Flight> selectAllFlights);
}
