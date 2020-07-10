package com.example.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repos.IAdminRepo;
import com.example.demo.services.IAdminService;

public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	IAdminRepo adminRepo;
	

}
