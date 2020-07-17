package com.example.demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configurable
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	protected UserDetailsService userDetailsService() {
		return new com.example.demo.config.UserDetailsServiceImpl();
		
	}
	/*
	@Override
	protected UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	
		manager.createUser(User.withDefaultPasswordEncoder().username("admin").password("123").roles("admin").build());
		//manager.createUser(User.withDefaultPasswordEncoder().username().password("123").roles("user").build());
		
		return manager;
	}*/

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
	}

	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authP= new DaoAuthenticationProvider();
		authP.setUserDetailsService(userDetailsService());
		authP.setPasswordEncoder(passwordEncoder());
		return authP;
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder authP) throws Exception {
		authP.authenticationProvider(authProvider());
		
		//auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
		
	}
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin/**").hasAuthority("admin")
		.antMatchers("/registeredUser/**").hasAnyAuthority("user", "admin")
		.antMatchers("/test").permitAll()
		//.hasAnyAuthority("admin","user")
		//.antMatchers("**").permitAll()
		//.antMatchers("/test").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		.antMatchers("/registration_form","/save","/showAllFlights/**").permitAll()
		
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()//http://localhost:8080/login
		.and()
		.logout().permitAll();//http://localhost:8080/logout
		
		
		//lai tiktu klāt h2 datubazei
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
}
