package com.example.demo.models;

import java.util.Collection;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.demo.config.UserAuthorities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
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
	
	private String password;
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="U_ID")
	private UserAuthorities role;  

	@ToString.Exclude
	@OneToMany(mappedBy="regU")
	private Collection<Flight> allRegUFlights;
	@ToString.Exclude
	@OneToMany(mappedBy="regUser")
	private Collection<BoardingPass> boardingPasses;
	
	@ToString.Exclude
	@OneToOne(mappedBy="regUser")
	private VipUser vipUser;

	public RegisteredUser(
			@Size(min = 3, max = 15) @Pattern(regexp = "[a-zA-Z ]+$", message = "Only letters and spaces allowed") String name,
			@Size(min = 3, max = 15) @Pattern(regexp = "[a-zA-Z ]+$", message = "Only letters and spaces allowed") String surname,
			@Min(0) @Max(100) int age,
			@Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$", message = "Invalid phone number") int phoneNumber,
			@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "Invalid e-mail adress") String email,
			@Min(0) @Max(10000) double points, Collection<BoardingPass> boardingPasses, VipUser vipUser) {
		super(name, surname, age, phoneNumber, email);
		this.points = points;
		this.boardingPasses = boardingPasses;
		this.vipUser = vipUser;
	}

	public RegisteredUser(
			@Size(min = 3, max = 15) @Pattern(regexp = "[a-zA-Z ]+$", message = "Only letters and spaces allowed") String name,
			@Size(min = 3, max = 15) @Pattern(regexp = "[a-zA-Z ]+$", message = "Only letters and spaces allowed") String surname,
			@Min(0) @Max(100) int age, int phoneNumber,
			@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "Invalid e-mail adress") String email,
			String password) {
		super(name, surname, age, phoneNumber, email);
		this.password = password;
	}

	public RegisteredUser(
			@Size(min = 3, max = 15) @Pattern(regexp = "[a-zA-Z ]+$", message = "Only letters and spaces allowed") String name,
			@Size(min = 3, max = 15) @Pattern(regexp = "[a-zA-Z ]+$", message = "Only letters and spaces allowed") String surname,
			@Min(0) @Max(100) int age, int phoneNumber,
			@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "Invalid e-mail adress") String email,
			String password, UserAuthorities role) {
		super(name, surname, age, phoneNumber, email);
		this.password = password;
		this.role = role;
	}

	public boolean deleteFlightFromRegUser(int id) {
		Iterator<Flight> newIter = allRegUFlights.iterator();
		
		while(newIter.hasNext()) {
			Flight newF = newIter.next();
			if(newF.getF_ID() == id) {
				newF = null;
				return true;
				
			}
		}
		
		return false;
	}

	
	


	
	
	
}
