package com.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.models.GeoLocation;
import com.project.api.repositories.UserRepository;
import com.project.api.services.GeoLocationService;

@RestController
@RequestMapping("/geolocation")
public class GeoLocationController {
  
  @Autowired
  private GeoLocationService geoLocationService;

	
	public GeoLocationController(GeoLocationService geoLocationService) {
    this.geoLocationService = geoLocationService;

	}
	
	@PatchMapping("/update/{userId}")
	public ResponseEntity<GeoLocation> updateGeoLocation(@RequestBody GeoLocation geoLocation, @PathVariable String userId) {
    return geoLocationService.update(geoLocation, userId);
  }
  


}