package com.example.demo.models;

import java.util.Collection;

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

@Entity
@Table(name = "AirportTable")
@Getter @Setter @NoArgsConstructor
public class Airport {
	
	@Column(name = "Country")
	public Countries country;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	@Column(name = "A_ID" )
	public int a_ID;
	
	@Min(1)
	@Max(99)
	int number;
	
	
	@Column(name = "AirportCode")
	public String airportCode;
	
	@OneToMany(mappedBy="airport")
	private Collection<Flight> airportFlights;
	
	
	
	
	public Airport(Countries country, int number) {
		super();
		this.country = country;
		generateAirportCode();
		airportCode += number;
	}
	
	
	
	public void generateAirportCode() {
		String code = "";
		for(int i = 0; i < 3; i++) {
			code += getCountry().toString().charAt(i);
		}
		airportCode = code;
	}




	
	
	
	


	
	
}
