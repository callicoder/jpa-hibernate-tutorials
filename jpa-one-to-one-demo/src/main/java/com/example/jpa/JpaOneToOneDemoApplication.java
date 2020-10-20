package com.example.jpa;

import com.example.jpa.model.Gender;
import com.example.jpa.model.User;
import com.example.jpa.model.UserProfile;
import com.example.jpa.repository.UserProfileRepository;
import com.example.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class JpaOneToOneDemoApplication implements ApplicationRunner {


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToOneDemoApplication.class, args);
	}

	@GetMapping("/users")
	public Collection<User> getUsers(){
		return userRepository.findAll();
	}

	@GetMapping("/user_profiles")
	public Collection<UserProfile> getUserProfiles(){
		return userProfileRepository.findAll();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		UserProfile userProfile1 = new UserProfile();
		userProfile1.setAddress1("Address 1");
		userProfile1.setAddress2("Address 2");
		userProfile1.setCity("City 1");
		userProfile1.setCountry("Country 1");
		userProfile1.setDateOfBirth(new Date());
		userProfile1.setGender(Gender.FEMALE);


		User user1 = new User();
		user1.setEmail("example@gmail.com");
		user1.setFirstName("SomeFirstName");
		user1.setLastName("SomeLastName");
		user1.setPassword("SomePassword");
		userRepository.save(user1);

		userProfile1.setUser(user1);
		userProfileRepository.save(userProfile1);

		userProfileRepository.findAll().forEach(userProfile -> {
			System.out.println(userProfile.getAddress1() + " " + userProfile.getAddress2());
			System.out.println(userProfile.getUser().getFirstName() + " " + userProfile.getUser().getLastName());
		});

	}
}
