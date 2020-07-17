package com.example.demo.models;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.example.demo.enums.Countries;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "AirportTable")
@Getter @Setter @NoArgsConstructor @ToString
public class Airport {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	@Column(name = "A_ID" )
	@ToString.Exclude
	private int a_ID;
	
	@Min(0)
	@ToString.Exclude
	int number;
	
	@Column(name = "Country")
	@ToString.Exclude
	private Countries country;
	
	@Column(name = "AirportCode")
	private String airportCode;
	/*
	@ManyToOne(targetEntity = Flight.class)
	private Flight flight;
	*/
	
	@ManyToMany
	@ToString.Exclude
	@JoinTable(name="Flight_Airport", joinColumns=@JoinColumn(name="A_ID"), inverseJoinColumns=@JoinColumn(name="F_ID") )
	private Collection<Flight> flights;
	
	public Airport(Countries country, int number) {
		super();
		this.country = country;
		generateAirportCode();
		flights = new ArrayList<Flight>();
		airportCode += number;
		flights= new ArrayList<Flight>();
	}
	
	
	
	public void generateAirportCode() {
		String code = "";
		for(int i = 0; i < 3; i++) {
			code += getCountry().toString().charAt(i);
		}
		airportCode = code;
	}


	/*
	public Airport(Countries country, //@Min(1) @Max(99) 
			int number, String airportCode) {
		super();
		this.country = country;
		this.number = number;
		this.airportCode = airportCode;
	}
	 */


	
}
