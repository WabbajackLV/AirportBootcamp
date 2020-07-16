package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.models.RegisteredUser;
import com.example.demo.repos.IRegisteredUserRepo;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	IRegisteredUserRepo regUrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		RegisteredUser user= regUrepo.findByEmail(username);
		if(user==null)
		{
			throw new UsernameNotFoundException( "Username does not exist");
			
		}
		return new AirportUserDetails(user);
	}

}
