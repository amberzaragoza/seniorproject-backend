package com.project.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.models.AppUser;
import com.project.api.models.Business;
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

  public void save(Business business, String userId) {
    AppUser owner = userRepository.findById(userId).get();
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

}
