package com.example.demo.models;

import java.util.ArrayList;
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
	private double points;
	
	@OneToMany(mappedBy="regUser")
	//@Column(name = "AllBoardingPasses")
	private Collection<BoardingPass> allBoardingPasses;
}
