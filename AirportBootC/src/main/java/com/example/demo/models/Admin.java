package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor 
@Entity
@Table(name="AdminTable")
public class Admin extends Person {

	
	
}
