package com.example.demo.utils;

import com.example.demo.models.Airport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class FlightInformation {
	private Airport airportFrom;
	
	private Airport airportTo;
	
	private double price;
	
	private double flightDuration;
	
	
	
	
}
