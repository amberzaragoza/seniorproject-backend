package com.project.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.models.Business;
import com.project.api.services.BusinessService;

@RestController
@RequestMapping("/business")
public class BusinessController {
  
  @Autowired
  private BusinessService businessService;
  
	public BusinessController(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	// Post Requests
	@PostMapping("/post/{userId}")
	public void saveBusiness(@RequestBody Business business, @PathVariable String userId) {
    businessService.save(business, userId);
	}
	
	//Get Requests
	@GetMapping("/get/id/{id}")
	public Optional<Business> getBusinessById(@PathVariable String id) {
		return businessService.getBusinessById(id);
  }
  
  @GetMapping("/get/owner/{ownerId}")
  public Business getBusinessByOwnerId(@PathVariable String ownerId){
    return businessService.getBusinessByOwnerId(ownerId);
  }
	
	

}
