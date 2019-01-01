package com.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.models.AppUser;
import com.project.api.repositories.UserRepository;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

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
		Point point = new GeometryFactory().createPoint(new Coordinate(35, -119));
		user.setLocation(point);
		userRepository.save(user);
  }
  
  @GetMapping("/get/id/{id}")
  public AppUser getAppUserById(@PathVariable String id){
    return userRepository.findById(id).get();
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