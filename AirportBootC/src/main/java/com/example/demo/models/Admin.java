package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="AdminTable")
public class Admin extends Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="A_ID")
	private long a_ID;
	
	Admin()
	{
		
	}

	public long getA_ID() {
		return a_ID;
	}

	@Override
	public String toString() {
		return "Admin [a_ID=" + a_ID + "]";
	}
	
}
