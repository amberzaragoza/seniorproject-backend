package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.api.models.GeoLocation;

@Repository
public interface GeoLocationRepository extends JpaRepository<GeoLocation, String> {}
