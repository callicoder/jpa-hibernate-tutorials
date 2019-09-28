package com.amit.jpa.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.jpa.model.User;
import com.amit.jpa.model.UserProfile;
import com.amit.jpa.service.AppService;

/**
*
* @author Amit Patil
*
**/
@RestController
@RequestMapping("/v1")
public class AppController {

	@Autowired
	private AppService appService;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User saveUserDetails(@RequestBody User user) {
		return appService.saveUserDetails(user);
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserDetailsById(@PathVariable("userId") Long id) {
		return appService.getUserDetailsById(id);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUserDetails() {
		return appService.getAllUserDetails();
	}
	
	@RequestMapping(value = "/userProfile", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserProfile saveUserProfileDetails(@RequestBody UserProfile userProfile) {
		return appService.saveUserProfile(userProfile);
	}
	
	@RequestMapping(value = "/userProfile/{userProfileId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserProfile getUserProfileDetails(@PathVariable("userProfileId") Long id) {
		return appService.getUserProfileDetails(id);
	}
	
	@RequestMapping(value = "/userProfiles", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserProfile> getAllUserProfiles() {
		return appService.getAllUserProfileDetails();
	}
}
