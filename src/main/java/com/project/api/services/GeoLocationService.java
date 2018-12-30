package com.project.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.api.models.AppUser;
import com.project.api.models.GeoLocation;
import com.project.api.repositories.GeoLocationRepository;
import com.project.api.repositories.UserRepository;


@Service
public class GeoLocationService {

  @Autowired
  private GeoLocationRepository geoLocationRepository;
  @Autowired
  private UserRepository userRepository;

  public GeoLocationService(GeoLocationRepository geoLocationRepository, UserRepository userRepository) {
    this.geoLocationRepository = geoLocationRepository;
    this.userRepository = userRepository;

  }

  public ResponseEntity<GeoLocation> update(GeoLocation geoLocation, String userId) {
    AppUser user = userRepository.findById(userId).get();
    GeoLocation gl = geoLocationRepository.findById(user.getGeolocation().getId()).get();
    gl.setLatitude(geoLocation.getLatitude());
    gl.setLongitude(geoLocation.getLongitude());
    gl.setIsShownOnMap(geoLocation.isIsShownOnMap());
    geoLocationRepository.save(gl);


    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(gl, httpHeaders, HttpStatus.OK);
  }


  public ResponseEntity<GeoLocation> save(GeoLocation geoLocation) {
    geoLocation = geoLocationRepository.save(geoLocation);
    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(geoLocation, httpHeaders, HttpStatus.OK);
  }


}
