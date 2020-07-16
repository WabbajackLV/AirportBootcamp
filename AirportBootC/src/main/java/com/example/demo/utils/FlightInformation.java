package com.example.demo.utils;


import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
	
	@Min(0)
	private double price;
	
	@DateTimeFormat(pattern = "dd.MM.yyyy HH:mm", iso = ISO.DATE)
	private LocalDateTime departureDate;
	
	/*
	@Min(value = 0, message = "cant be below 0")
	@Max(value = 23, message = "cant be above 23")
	private int departureTimeHours;
	
	@Min(value = 0, message = "cant be above 23")
	@Max(value = 59, message = "cant be above 59")
	private int departureTimeMinutes;
	*/
	
	@DecimalMin(value = "0.30", message = "cant be below 0.30")
	@DecimalMax(value = "24.00", message = "cant be above 24.00")
	private double flightDuration;
	
	@Min(value = 14, message = "cant be below 14")
	@Max(value = 200, message = "cant be abowe 200")
	private int passengerCapacity;
	


	
	
}
