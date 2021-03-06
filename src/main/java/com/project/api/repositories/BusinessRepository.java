package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.project.api.models.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, String> {
  
}
