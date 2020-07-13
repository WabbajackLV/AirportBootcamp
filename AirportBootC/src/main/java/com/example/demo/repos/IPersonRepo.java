package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Person;

public interface IPersonRepo extends CrudRepository<Person, Integer>{

}
