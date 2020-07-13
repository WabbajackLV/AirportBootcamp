package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SeatTable")
@Getter @Setter @NoArgsConstructor
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	@Column(name = "S_ID" )
	private int s_ID;
	
	@Min(1)
	private int seatNumber;
	
	public Seat(@Min(1) int seatNumber) {
		super();
		this.seatNumber = seatNumber;
	}
	
	
}
