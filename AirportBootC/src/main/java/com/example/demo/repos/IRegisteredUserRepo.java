package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.RegisteredUser;

public interface IRegisteredUserRepo extends CrudRepository<RegisteredUser, Integer>{

	boolean existsByEmail(String email);

	RegisteredUser findByEmail(String email);

}
