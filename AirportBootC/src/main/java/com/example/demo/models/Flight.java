package com.example.demo.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(name = "Price")
	@Min(0)
	private double price;
	
	@Min(0)
	@Column(name = "SeatsTaken")
	private int seatsTaken;

	@OneToMany(mappedBy="flight")
	private Collection<BoardingPass> boardingPasses;
	
	@ManyToOne
	@JoinColumn(name="A_ID")
	private Airport airport;
	
	

	public Flight(Airport airportFrom, Airport airportTo,
			Date departureDate, double flightDuration, int passengerCapacity, double price) {
		this.airportFrom = airportFrom;
		this.airportTo = airportTo;
		this.departureDate = departureDate;
		this.flightDuration = flightDuration;
		this.passengerCapacity = passengerCapacity;
		this.price = price;
		seatsTaken = 0;
		
	}

	
	public void takeOneVipSeat() {
		vipSeatCounter++;
	}
	
	public void takeOneRegSeat() {
		regSeatCounter++;
	}


	}

