package com.project.api.services;

import com.project.api.models.ViewNearby;
import com.project.api.repositories.CustomQueriesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomQueriesService {

  @Autowired
  private CustomQueriesRepository customQueriesRepository;

  public CustomQueriesService(CustomQueriesRepository customQueriesRepository){
    this.customQueriesRepository = customQueriesRepository;
  }

  public ResponseEntity<ViewNearby> findAllByDistance(double latitude, double longitude){
    ViewNearby data = customQueriesRepository.findAllByDistance(latitude, longitude);
    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(data, httpHeaders, HttpStatus.OK);

  }



}
