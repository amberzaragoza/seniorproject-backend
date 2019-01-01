package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.project.api.models.ViewNearby;

@Repository
public interface CustomQueriesRepository extends JpaRepository<ViewNearby, Long> {
  // @Query("SELECT * FROM geolocation WHERE ST_DWithin(geom::geography, ST_GeogFromText('SRID=4326;Point(35 -119)'), 25.06*1609.344) --miles*meters = convert miles to meters AND geolocation.is_shown_on_map=true;")
  public ViewNearby findAllByDistance(double latitude, double longitude);

}