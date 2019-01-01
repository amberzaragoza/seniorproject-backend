package com.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.models.ViewNearby;
import com.project.api.services.CustomQueriesService;

@RestController
@RequestMapping("/views")
public class CustomQueriesController {
  
  @Autowired
  private CustomQueriesService customQueriesService;

  public CustomQueriesController(CustomQueriesService customQueriesService){
    this.customQueriesService = customQueriesService;
  }

  @GetMapping("/nearby/lat/{latitude}/long/{longitude}")
  public ResponseEntity <ViewNearby> getNearbyBusinesses(@PathVariable double latitude,
                                                         @PathVariable double longitude){

    return customQueriesService.findAllByDistance(latitude, longitude);
  }

  


}