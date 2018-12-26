package com.project.api;

import com.project.api.models.AppUser;
import com.project.api.models.Business;
import com.project.api.repositories.BusinessRepository;
import com.project.api.repositories.UserRepository;

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

  //test data 
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BusinessRepository businessRepository;

	@Override
	public void run(String... arg0) throws Exception {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		AppUser newUser = new AppUser();
		newUser.setUsername("jobstevens@gmail.com");
		newUser.setPassword(passwordEncoder.encode("aaa"));
		newUser.setFirstName("Job");
		newUser.setLastName("Stevens");
		newUser.setAvatarLink("https://ninjawiththeorangetshirt.files.wordpress.com/2010/11/jobbbs.jpg");
		newUser = userRepository.save(newUser);

		Business business = new Business();
		business.setName("Bob's Mobile PC Repair");
		business.setState("CA");
		business.setOwner(newUser);
		business.setEmail("JobsPcRepair@gmail.com");
		business.setPrimaryPhone("6618645654");
		business.setAltPhone("6615585324");
		business.setStreet("7900 Pegasus Dr.");
		business.setCity("Bakersfield");
		business.setZip("93301");
		businessRepository.save(business);





	}

}
