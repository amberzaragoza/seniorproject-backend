package com.project.api;

import com.project.api.models.AppUser;
import com.project.api.models.Business;
import com.project.api.repositories.BusinessRepository;
import com.project.api.repositories.UserRepository;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEndcoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	// test data
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BusinessRepository businessRepository;

	@Override
	public void run(String... arg0) throws Exception {

		String[][] users = { {"jobstevens@gmail.com", "aaa", "Job", "Stevens", "https://ninjawiththeorangetshirt.files.wordpress.com/2010/11/jobbbs.jpg", "35.350204", "-119.104669"},
												 {"AZ@gmail.com", "password", "Amber", "Zaragoza", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "0.0", "0.0"},
												 {"tommychong@gmail.com", "aaa", "Tommy", "Chong", "hhttps://cdn.inquisitr.com/wp-content/uploads/2016/05/Tommy.jpg", "35.354055", "-119.092246"},
												 {"billgates@gmail.com", "aaa", "Bill", "Gates", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Bill_Gates_June_2015.jpg/424px-Bill_Gates_June_2015.jpg", "35.355239", "-119.058780"}
	
		};
		String[][] businesses = { {"Orange Computer Repair", "CA", "OrangePcRepair@gmail.com", "6615552365", "6615553248", "7900 Pegasus Dr.", "Bakersfield", "93301", "Technology"},
															 null,
															{"Chong Bongs", "CA", "chongbongs@gmail.com", "6615552365", "6615553248", "8156 Orange Dr.", "Bakersfield", "93302", "Cannabis"},
															{"Microsoft Computer Repair", "CA", "microsoft@gmail.com", "6615552365", "6615553248", "8156 Mountain View Rd.", "Bakersfield", "93302", "Technology"},
		};

		createUsersFromArray(users, businesses);

	}

	public void createUsersFromArray(String[][] users, String[][] businesses){
		for(int i = 0; i < users.length; i++){
			createUsersAndBusinesses(users[i], businesses[i]);
		}
	}

	public void createUsersAndBusinesses(String[] user, String[] businessInfo) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		AppUser newUser = new AppUser();
		newUser.setUsername(user[0]);
		newUser.setPassword(passwordEncoder.encode(user[1]));
		newUser.setFirstName(user[2]);
		newUser.setLastName(user[3]);
		newUser.setAvatarLink(user[4]);

		Point point = new GeometryFactory().createPoint(new Coordinate(0.0, 0.0));
		newUser.setLocation(point);
		newUser.setLatitude(Double.valueOf(user[5]));
		newUser.setLongitude(Double.valueOf(user[6]));
		newUser.setIsOnline(true);

		userRepository.save(newUser);

		if(businessInfo != null){
			Business business = new Business();
			business.setName(businessInfo[0]);
			business.setState(businessInfo[1]);
			business.setOwner(newUser);
			business.setEmail(businessInfo[2]);
			business.setPrimaryPhone(businessInfo[3]);
			business.setAltPhone(businessInfo[4]);
			business.setStreet(businessInfo[5]);
			business.setCity(businessInfo[6]);
			business.setZip(businessInfo[7]);
			business.setIndustry(businessInfo[8]);
			businessRepository.save(business);

		}



	}

}
