package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @NoArgsConstructor @ToString
@Entity
@Table(name="AdminTable")
public class Admin extends Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="A_ID")
	private int a_ID;

}
