package com.amit.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.jpa.model.User;

/**
*
* @author Amit Patil
*
**/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
