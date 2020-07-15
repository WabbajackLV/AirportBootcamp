package com.example.demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configurable
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//.antMatchers("/registeredUser/register").anonymous()
		.antMatchers("/**").permitAll()
		//.antMatchers("/test").permitAll()
		//.antMatchers("/h2-console/**").permitAll()
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
