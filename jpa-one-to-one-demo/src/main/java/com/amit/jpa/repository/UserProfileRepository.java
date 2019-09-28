package com.amit.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.jpa.model.UserProfile;

/**
*
* @author Amit Patil
*
**/
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
