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

	/** 
	 * @Use: Hql query to find all users within a specified distance (radius in miles) between two or more users. 
	 * @param latitude: The queryers geographical lattitude coordinate.
	 * @param longitude: The queryers geographical longitude coordinate.
	 * @param radus: The search area radius (in miles) provided by the queryer.
	 * @return: A list of appuser entities.
	 */ 
	@Query("SELECT a FROM AppUser a WHERE (((acos(sin(((:latitude)*pi()/180)) * " +
	"sin((a.latitude*pi()/180))+cos(((:latitude)*pi()/180)) * cos((a.latitude*pi()/180)) * " +
	"cos((((:longitude)- a.longitude)*pi()/180))))*180/pi())*60*1.1515) <=:radius AND a.isOnline=true")
	public List<AppUser> find(@Param("latitude") Double latitude, 
														@Param("longitude") Double longitude, 
														@Param("radius") Double radius);
}
