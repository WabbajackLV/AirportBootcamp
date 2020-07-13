package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "BoardingPassTable")
@Entity
@Getter	@Setter @NoArgsConstructor
public class BoardingPass {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	@Column(name = "B_ID")
	private int b_ID;
	
	/*
	@Column(name = "Price")
	private double price;
	*/
	
	
	@Column(name = "RegUser")
	private RegisteredUser regUser;
	
	@Column(name = "Priority")
	private boolean priority;
	
	@OneToOne(mappedBy="boardingPass")
	private Seat seat;
	
	@ManyToOne
	@JoinColumn(name="F_ID")
	private Flight flight;
	
	public BoardingPass(Flight flight, RegisteredUser regUser) {
		super();
		this.flight = flight;
		this.regUser = regUser;
		this.priority = isRegUserAVip(regUser);
		try {
			seat = generateSeat(flight, regUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public boolean isRegUserAVip(RegisteredUser user) {
		if(user instanceof VipUser) {
			return true;
		}
		return false;
	}
	
	public Seat generateSeat(Flight flight, RegisteredUser user) throws Exception {
		if(user instanceof VipUser) {
			int seatNumber = flight.getVipSeatCounter(); 
			if(seatNumber <= flight.getVipCapacity()) {
				Seat vipSeat = new Seat(seatNumber);
				flight.takeOneVipSeat();
				return vipSeat;
			}else {
				throw new Exception("All Vip seats taken");
			}
		}else {
			int seatNumber = flight.getVipCapacity() + flight.getRegSeatCounter();
			if(seatNumber <= flight.getPassengerCapacity()) {
				Seat regularSeat = new Seat(seatNumber);
				flight.takeOneRegSeat();
				return regularSeat;
			}else {
				throw new Exception("All regular seats taken");
			}
		}
		
	}


	
	
}
