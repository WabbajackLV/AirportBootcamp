package com.example.demo.models;

import java.util.Date;

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
public class Flight extends Airport{
	
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
	
	
	@Column(name = "FligthDuration")
	private double flightDuration;
	
	@Column(name = "PassengerCapacity")
	private int passengerCapacity;
	
	@Min(0)
	@Column(name = "SeatsTaken")
	private int seatsTaken;

	public Flight(int f_ID, Airport airportFrom, Airport airportTo, BoardingPass boardingPass, Date departureDate,
			double flightDuration, int passengerCapacity) {
		super();
		this.f_ID = f_ID;
		this.airportFrom = airportFrom;
		this.airportTo = airportTo;
		this.boardingPass = boardingPass;
		this.departureDate = departureDate;
		this.flightDuration = flightDuration;
		this.passengerCapacity = passengerCapacity;
	}


	
	//TODO toString();
	
	
	
}
