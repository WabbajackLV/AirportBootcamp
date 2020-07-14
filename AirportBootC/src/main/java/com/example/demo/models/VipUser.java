package com.example.demo.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.Entity;


import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "VipUserTable")
@Getter @Setter @NoArgsConstructor

public class VipUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	@Column(name = "VU_ID" )
	private int vu_id;
	
	@OneToOne
	@JoinColumn(name="RU_ID")
	private RegisteredUser regUser ;

	public VipUser(RegisteredUser regUser) {
		super();
		this.regUser = regUser;
	}
	
	
	

public class VipUser extends RegisteredUser{
	
	public VipUser (RegisteredUser user) {
	}

}
