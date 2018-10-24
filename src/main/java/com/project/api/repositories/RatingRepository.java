package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.api.models.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

}