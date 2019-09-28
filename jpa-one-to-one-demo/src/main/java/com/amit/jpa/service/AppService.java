package com.amit.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.amit.jpa.model.User;
import com.amit.jpa.model.UserProfile;
import com.amit.jpa.repository.UserProfileRepository;
import com.amit.jpa.repository.UserRepository;

/**
*
* @author Amit Patil
*
**/
public class AppService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	public User saveUserDetails(User user) {
		return userRepository.save(user);
	}
	
	public User getUserDetailsById(Long id) {
		return userRepository.findById(id).get();
	}
	
	public List<User> getAllUserDetails() {
		return userRepository.findAll();
	}
	
	public UserProfile saveUserProfile(UserProfile userProfile) {
		return userProfileRepository.save(userProfile);
	}
	
	public UserProfile getUserProfileDetails(Long id) {
		return userProfileRepository.findById(id).get();
	}
	
	public List<UserProfile> getAllUserProfileDetails() {
		return userProfileRepository.findAll();
	}
}
	