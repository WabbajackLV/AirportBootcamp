package com.example.demo.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


import com.example.demo.enums.Countries;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor 
@Table(name = "FlightTable")
@Entity
public class Flight{
	
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
	private Collection<BoardingPass> allBoardingPasses;
	
	@Column(name = "DepartureDate")
	private Date departureDate;
	
	
	@Column(name = "FligthDuration")
	private double flightDuration;
	
	@Column(name = "PassengerCapacity")
	private int passengerCapacity;
	
	private int vipCapacity = passengerCapacity/3;
	private int regularCapacity = passengerCapacity - vipCapacity;
	
	private int vipSeatCounter = 1; 
	private int regSeatCounter = 1;
	
	@Min(0)
	@Column(name = "SeatsTaken")
	private int seatsTaken;

	@OneToMany(mappedBy="Flight")
	private Collection<BoardingPass> boardingPasses;

	public Flight(Airport airportFrom, Airport airportTo,
			Date departureDate, double flightDuration, int passengerCapacity) {
		this.airportFrom = airportFrom;
		this.airportTo = airportTo;
		this.departureDate = departureDate;
		this.flightDuration = flightDuration;
		this.passengerCapacity = passengerCapacity;
		seatsTaken = 0;
		
	}



	public Flight(int id, String code, Airport airportFrom, Airport airportTo,
			Collection<BoardingPass> allBoardingPasses, Date departureDate, double flightDuration,
			int passengerCapacity, @Min(0) int seatsTaken) {
		this.airportFrom = airportFrom;
		this.airportTo = airportTo;
		this.allBoardingPasses = allBoardingPasses;
		this.departureDate = departureDate;
		this.flightDuration = flightDuration;
		this.passengerCapacity = passengerCapacity;
		this.seatsTaken = seatsTaken;
	}
	
	public void takeOneVipSeat() {
		vipSeatCounter++;
	}
	
	public void takeOneRegSeat() {
		regSeatCounter++;
	}


	}

