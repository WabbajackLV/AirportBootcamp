package com.example.demo.config;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.models.RegisteredUser;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="UserAuthorities")
@Getter @Setter @NoArgsConstructor @ToString
public class UserAuthorities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	@Column(name = "U_ID" )
	private int u_id;
	
	
	@Column(name="RoleName")
	private String roleName;
	
	
	@ToString.Exclude
	@OneToMany(mappedBy="role",fetch = FetchType.EAGER)
	private Collection<RegisteredUser> regUsers;

	public UserAuthorities(String role) {
		super();
		this.roleName = role;
		regUsers=new ArrayList<>();
	}
	public void addUserToRole(RegisteredUser regU) {
		
		regUsers.add(regU);
		
	}
	
	
}
