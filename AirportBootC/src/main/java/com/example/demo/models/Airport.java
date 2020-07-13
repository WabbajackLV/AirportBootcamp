package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.enums.Cities;
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
	
	@Column(name = "City")
	public Cities city;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	@Column(name = "A_ID" )
	public int a_ID;
	public String code;
	

	public Airport(Countries country, Cities city, int id, String code) {
		super();
		this.country = country;
		this.city = city;
		this.a_ID = id;
		this.code = code;
	}
	
	
}
