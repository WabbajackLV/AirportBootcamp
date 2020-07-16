package com.example.demo.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.example.demo.enums.Countries;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Table(name = "FlightTable")
@Entity(name = "FlightEntity")
public class Flight{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	@Column(name = "F_ID" )
	private int f_ID;
	
	/*@OneToOne
	@JoinColumn(name="A_ID")
	//@Column(name = "AirportFrom")
	private Airport airportFrom;
	@OneToOne
	@JoinColumn(name="A_ID")
	//@Column(name = "AirportTo")
	private Airport airportTo;
	
	
	@OneToMany
	@JoinColumn(name="A_ID")
	private Collection<Airport> airportFromAndTo;
	*/
	
	@ManyToMany(mappedBy="flights")
	private Collection<Airport> airportFromAndTo;
	
	@Column(name = "DepartureDate")
	@DateTimeFormat(pattern = "dd.MM.yyyy HH:mm", iso = ISO.DATE)
	private LocalDateTime departureDate;
	
	
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

	/*
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
*/
	
	
	public void takeOneVipSeat() {
		vipSeatCounter++;
	}
	
	public void takeOneRegSeat() {
		regSeatCounter++;
	}

	public Flight(Airport airportFrom, Airport airportTo, LocalDateTime departureDate, double flightDuration, int passengerCapacity, double price) {
		airportFromAndTo.add(airportFrom);
		airportFromAndTo.add(airportTo);
		this.departureDate = departureDate;
		this.flightDuration = flightDuration;
		this.passengerCapacity = passengerCapacity;
		this.price = price;
		seatsTaken = 0;
	}
	
	public Flight(Collection<Airport> airportFromAndTo,LocalDateTime departureDate, double flightDuration, int passengerCapacity, double price) {
		this.airportFromAndTo = airportFromAndTo;
		this.departureDate = departureDate;
		this.flightDuration = flightDuration;
		this.passengerCapacity = passengerCapacity;
		this.price = price;
		seatsTaken = 0;
	}





	}

