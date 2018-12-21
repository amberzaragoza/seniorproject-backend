

package com.project.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.models.Business;
import com.project.api.models.Menu;
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
  @PostMapping("/post/{username}")
	public ResponseEntity<Business> saveBusiness(@RequestBody Business business, @PathVariable String username) {
    return businessService.save(business, username);
  }

  @PostMapping("/post/menu/{ownerId}")
  public ResponseEntity<Menu> postMenu(@PathVariable String ownerId, @RequestBody Menu menu){
    return businessService.addMenu(ownerId, menu);
  }

  @PostMapping("/post/rating/user/{username}/business/{businessId}")
  public ResponseEntity<Rating> postRating(@PathVariable String username, 
                         @PathVariable String businessId, 
                         @RequestBody Rating rating){      
    return businessService.addRating(username, businessId, rating);
  }
  
  // PATCH Requests =========================================================================
  @PutMapping("/update")
  public ResponseEntity<Business> updateBusiness(@RequestBody Business business){
    return businessService.update(business);
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

  @GetMapping("/get/menus/{ownerId}")
  public List<Menu> getMenus(@PathVariable String ownerId){
    return businessService.getAllMenus(ownerId);
  }

  // DELETE Requests ========================================================================
  @DeleteMapping("/delete/{id}")
  public void deleteBusiness(@PathVariable String id){
    businessService.delete(id);
  }

}
