package com.project.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.models.Business;
import com.project.api.repositories.BusinessRepository;

@Service
public class BusinessService {
  
  @Autowired
	private BusinessRepository businessRepository;
	
	public BusinessService(BusinessRepository businessRepository) {
		this.businessRepository = businessRepository;
	}
	
	public void save(Business business) {
		businessRepository.save(business);
	}
	
	public Optional<Business> getBusinessById(Long id) {
		return businessRepository.findById(id);
	}

}
