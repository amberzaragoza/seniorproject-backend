package com.project.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.api.models.AppUser;
import com.project.api.models.Business;
import com.project.api.models.Menu;
import com.project.api.models.Rating;
import com.project.api.repositories.BusinessRepository;
import com.project.api.repositories.MenuRepository;
import com.project.api.repositories.UserRepository;

@Service
public class BusinessService {

  @Autowired
  private BusinessRepository businessRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private MenuRepository menuRepository;

  public BusinessService(BusinessRepository businessRepository,
                         UserRepository userRepository,
                         MenuRepository menuRepository) {
                           
    this.businessRepository = businessRepository;
    this.userRepository = userRepository;
    this.menuRepository = menuRepository;
  }

  public void delete(String id) {
    businessRepository.deleteById(id);
  }

  public void save(Business business) {
    businessRepository.save(business);
  }

  public ResponseEntity<Business> save(Business business, String username) {
    AppUser owner = userRepository.findByUsername(username);
    business.setOwner(owner);
    Business b = businessRepository.save(business);

    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(b, httpHeaders, HttpStatus.OK);
  }

  public Optional<Business> getBusinessById(String id) {
    return businessRepository.findById(id);
  }

  public Business getBusinessByOwnerId(String ownerId) {
    AppUser owner = userRepository.findById(ownerId).get();
    return owner.getBusiness();
  }

  public List<Rating> getRatings(String businessId){
    Business business = businessRepository.findById(businessId).get();
    List<Rating> ratings = new ArrayList<>();
    business.getRatings().forEach(ratings::add);
    return ratings;
  }

  public ResponseEntity<Rating> addRating(String username, String businessId, Rating rating){
    Business business = businessRepository.findById(businessId).get();
    AppUser user = userRepository.findByUsername(username);
    rating.setUser(user);
    business.addRating(rating);
    save(business);

    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(rating, httpHeaders, HttpStatus.OK);                                
  }

  public List<Menu> getAllMenus(String ownerId){
    Business business = getBusinessByOwnerId(ownerId);
    List<Menu> menus = new ArrayList<>();
    business.getMenus().forEach(menus::add);
    return menus;
  }

  public ResponseEntity<Menu> addMenu(String ownerId, Menu menu){
    Business business = getBusinessByOwnerId(ownerId);
    menuRepository.save(menu);
    business.addMenu(menu);
    save(business);
    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(menu, httpHeaders, HttpStatus.OK);
  }

  public ResponseEntity<Business> update(Business business){
    save(business);
    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(business, httpHeaders, HttpStatus.OK);
  }
  


}
