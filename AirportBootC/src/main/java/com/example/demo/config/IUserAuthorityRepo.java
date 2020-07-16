package com.example.demo.config;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Flight;

public interface IUserAuthorityRepo extends CrudRepository<UserAuthorities, Integer> {

	UserAuthorities findByRoleName(String string);

}
