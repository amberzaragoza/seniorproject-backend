package com.project.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.models.Business;
import com.project.api.models.Rating;
import com.project.api.services.BusinessService;

@RestController
@RequestMapping("/business")
public class BusinessController {
  
  @Autowired
  private BusinessService businessService;
  
	public BusinessController(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	// POST Requests ==========================================================================
	@PostMapping("/post/{userId}")
	public void saveBusiness(@RequestBody Business business, @PathVariable String userId) {
    businessService.save(business, userId);
  }

  @PostMapping("/post/rating/{businessId}")
  public void postRating(@PathVariable String businessId, @RequestBody Rating rating){
    businessService.addRating(businessId, rating);
  }
  
  // PUT Requests ===========================================================================
  @PutMapping("/update")
  public void updateBusiness(@RequestBody Business business){
    businessService.save(business);
  }
	
	// GET Requests ===========================================================================
	@GetMapping("/get/id/{id}")
	public Optional<Business> getBusinessById(@PathVariable String id) {
		return businessService.getBusinessById(id);
  }
  
  @GetMapping("/get/owner/{ownerId}")
  public Business getBusinessByOwnerId(@PathVariable String ownerId){
    return businessService.getBusinessByOwnerId(ownerId);
  }

  @GetMapping("/get/ratings/{businessId}")
  public List<Rating> getRatings(@PathVariable String businessId){
    return businessService.getRatings(businessId);
  }

  // DELETE Requests ========================================================================
  @DeleteMapping("/delete/{id}")
  public void deleteBusiness(@PathVariable String id){
    businessService.delete(id);
  }
	
}
