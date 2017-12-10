package com.example.jpa.repository;

import com.example.jpa.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 20/11/17.
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
