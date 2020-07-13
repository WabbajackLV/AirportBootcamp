package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "BoardingPassTable")
@Entity
@Getter	@Setter @NoArgsConstructor
public class BoardingPass {
	private String BoardingNr;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	@Column(name = "B_ID")
	private int b_ID;
	
	@Column(name = "Price")
	private double price;
	
	@Column(name = "Seat")
	private Seat seat;
	
	@Column(name = "RegUser")
	private RegisteredUser regUser;
	
	@Column(name = "Priority")
	private boolean priority;
	
	
	
}
