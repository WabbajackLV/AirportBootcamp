package com.example.demo.models;


import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SeatTable")
@Getter @Setter @NoArgsConstructor
public class VipUser extends RegisteredUser{
	
	public VipUser (RegisteredUser user) {
	}
}
