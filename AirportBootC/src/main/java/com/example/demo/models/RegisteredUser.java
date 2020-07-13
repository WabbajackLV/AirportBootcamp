package com.example.demo.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Table(name = "RegisteredUserTable")
@Entity
public class RegisteredUser extends Person{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	@Column(name = "RU_ID" )
	private int ru_id;
	
	@Min(0)
	@Max(10000)
	@Column(name = "Points")
	private int points;
	
	@Column(name = "AllBoardingPasses")
	private ArrayList<BoardingPass> allBoardingPasses;
}
