package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.project.api.models.AppUser;
@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {
	public AppUser findByUsername(String username);
	public AppUser findByResetToken(String resetToken);

	@Query("SELECT a FROM AppUser a WHERE (((acos(sin(((:latitude)*pi()/180)) * " +
     "sin((a.latitude*pi()/180))+cos(((:latitude)*pi()/180)) * cos((a.latitude*pi()/180)) * " +
		 "cos((((:longitude)- a.longitude)*pi()/180))))*180/pi())*60*1.1515) <=50 AND a.isOnline=true")
		 public List<AppUser> find(@Param("latitude") Double latitude, @Param("longitude") Double longitude);
}
