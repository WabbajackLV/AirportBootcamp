package com.example.demo.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.models.RegisteredUser;

public class AirportUserDetails implements UserDetails {

	RegisteredUser regU;
	
	
	public AirportUserDetails(RegisteredUser regU) {
		super();
		this.regU = regU;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority grantedA=new SimpleGrantedAuthority(regU.getRole().getRoleName());
		return Arrays.asList(grantedA);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return regU.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return regU.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
