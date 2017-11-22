package com.example.hibernateelementcollectiondemo.repository;

import com.example.hibernateelementcollectiondemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rajeevkumarsingh on 22/11/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
