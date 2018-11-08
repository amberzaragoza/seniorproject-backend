package com.project.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.models.AppUser;
import com.project.api.models.Business;
import com.project.api.models.Menu;
import com.project.api.models.Rating;
import com.project.api.repositories.BusinessRepository;
import com.project.api.repositories.UserRepository;

@Service
public class BusinessService {

  @Autowired
  private BusinessRepository businessRepository;
  @Autowired
  private UserRepository userRepository;

  public BusinessService(BusinessRepository businessRepository,
                         UserRepository userRepository) {
                           
    this.businessRepository = businessRepository;
    this.userRepository = userRepository;
  }

  public void delete(String id) {
    businessRepository.deleteById(id);
  }

  public void save(Business business) {
    businessRepository.save(business);
  }

  public void save(Business business, String username) {
    AppUser owner = userRepository.findByUsername(username);
    business.setOwner(owner);
    businessRepository.save(business);
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

  public void addRating(String username, String businessId, Rating rating){
    Business business = businessRepository.findById(businessId).get();
    AppUser user = userRepository.findByUsername(username);
    rating.setUser(user);
    business.addRating(rating);
    save(business);
  }

  public List<Menu> getAllMenus(String ownerId){
    Business business = getBusinessByOwnerId(ownerId);
    List<Menu> menus = new ArrayList<>();
    business.getMenus().forEach(menus::add);
    return menus;
  }

  public void addMenu(String ownerId, Menu menu){
    Business business = getBusinessByOwnerId(ownerId);
    business.addMenu(menu);
    save(business);
  }

}
