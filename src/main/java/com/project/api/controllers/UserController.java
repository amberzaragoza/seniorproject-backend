package com.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.project.api.models.AppUser;
import com.project.api.repositories.UserRepository;
// import com.vividsolutions.jts.geom.Coordinate;
// import com.vividsolutions.jts.geom.GeometryFactory;
// import com.vividsolutions.jts.geom.Point;

@RestController
@RequestMapping("/users")
public class UserController {
  
  @Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserController(UserRepository userRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@PostMapping("/sign-up")
	public void signup(@RequestBody AppUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		// Point point = new GeometryFactory().createPoint(new Coordinate(35, -119));
		// user.setLocation(point);
		userRepository.save(user);
  }
  
  @GetMapping("/get/id/{id}")
  public AppUser getAppUserById(@PathVariable String id){
    return userRepository.findById(id).get();
	}
	
	@PatchMapping("/update/user/{id}/lat/{latitude}/long/{longitude}/online/{isOnline}")
	public ResponseEntity<AppUser> updateLocation(@PathVariable String id, @PathVariable double latitude, 
																								@PathVariable double longitude, @PathVariable boolean isOnline){
		AppUser user = userRepository.findById(id).get();
		// Point point = new GeometryFactory().createPoint(new Coordinate(latitude, longitude));
		// user.setLocation(point);
		user.setLatitude(latitude);
		user.setLongitude(longitude);
		user.setIsOnline(isOnline);
		user = userRepository.save(user);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(user, httpHeaders, HttpStatus.OK);

	}

	@GetMapping("/get/dist/lat/{latitude}/long/{longitude}/radius/{radius}/ind/{industry}")
	public ResponseEntity<List<AppUser>> findByDistance(@PathVariable Double latitude, @PathVariable Double longitude, 
																	                    @PathVariable Double radius, @PathVariable String industry){
		List<AppUser> queryResult = userRepository.find(latitude, longitude, radius);
		List<AppUser> users = new ArrayList<>();
		for(AppUser user : queryResult){
			if(user.getBusiness().getIndustry().equals(industry)){
				users.add(user);
			}
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(users, httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, value="/get/email/{email}")
	public AppUser getAppUserByEmail(@PathVariable String email){
		AppUser user = userRepository.findByUsername(email);
		user.setPassword("");
		return user;
	}

	@RequestMapping(method=RequestMethod.GET, value="/get/resetToken/{resetToken}")
	public AppUser getAppUserByResetToken(@PathVariable String resetToken){
		AppUser user = userRepository.findByResetToken(resetToken);
		user.setPassword("");
		return user;
	}

}