package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	int counter = 1;
	
	
	@Column(name = "AirportCode")
	public String airportCode;
	
	
	public void generateAirportCode() {
		String code = "";
		for(int i = 0; i < 3; i++) {
			code += getCountry().toString().charAt(i);
		}
		code += counter;
		counter++;
		airportCode = code;
	}
	
	
	
	
	
	
	


	
	
}
