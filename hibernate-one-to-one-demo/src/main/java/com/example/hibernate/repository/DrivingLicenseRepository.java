package com.example.hibernate.repository;

import com.example.hibernate.model.DrivingLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 20/11/17.
 */
@Repository
public interface DrivingLicenseRepository extends JpaRepository<DrivingLicense, Long> {

}
