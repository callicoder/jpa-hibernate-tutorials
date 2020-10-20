package com.example.jpa;

import com.example.jpa.model.User;
import com.example.jpa.model.UserProfile;
import com.example.jpa.repository.UserProfileRepository;
import com.example.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@SpringBootApplication
@RestController
public class JpaOneToOneDemoApplication {


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
}
