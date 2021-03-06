package com.example.demo.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@MappedSuperclass
public class Person {

	@Column(name="Name")
	@Size(min = 3, max = 15)
	@Pattern(regexp="[a-zA-Z\\s]+$", message = "Only letters and spaces allowed")
	private String name;
	
	@Column(name="Surname")
	@Size(min = 3, max = 15)
	@Pattern(regexp="[a-zA-Z\\s]+$", message = "Only letters and spaces allowed")
	private String surname;
	
	@Column(name="Age")
	@Min(0)
	@Max(100)
	private int age;


	@Column(name="PhoneNumber")
	//@Pattern(regexp="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$", message = "Invalid phone number")
	private int phoneNumber;
	
	@Column(name="Email")
	@Pattern(regexp="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
	message = "Invalid e-mail adress")
	private String email;

	/*@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	*/
	
	 
	public Person(
			@Size(min = 3, max = 15) @Pattern(regexp = "[a-zA-Z ]+$", message = "Only letters and spaces allowed") String name,
			@Size(min = 3, max = 15) @Pattern(regexp = "[a-zA-Z ]+$", message = "Only letters and spaces allowed") String surname,
			@Min(0) @Max(100) int age,
			//@Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$", message = "Invalid phone number") 
			int phoneNumber,
			@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "Invalid e-mail adress") String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}


}
