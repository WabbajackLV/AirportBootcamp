package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor 
@Table(name = "FlightTable")
@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	@Column(name = "F_ID" )
	private int f_ID;
	
	@Column(name = "AirportFrom")
	private Airport airportFrom;
	
	@Column(name = "AirportTo")
	private Airport airportTo;
	
	@Column(name = "BoardingPass")
	private BoardingPass boardingPass;
	
	@Column(name = "DepartureDate")
	private Date departureDate;
	
	@Min(1)
	@Max(24)
	@Column(name = "Age")
	private double flightDuration;
	
	private int passengerCapacity;
	
	private int seatsTaken;
	
	//TODO toString();
	
	
	
}
