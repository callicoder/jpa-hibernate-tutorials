package com.example.hibernateonetoonedemo;

import com.example.hibernateonetoonedemo.model.Driver;
import com.example.hibernateonetoonedemo.model.DrivingLicense;
import com.example.hibernateonetoonedemo.repository.DriverRepository;
import com.example.hibernateonetoonedemo.repository.DrivingLicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class HibernateOneToOneDemoApplication implements CommandLineRunner {

	@Autowired
	private DriverRepository driverRepository;

	@Autowired
    private DrivingLicenseRepository drivingLicenseRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateOneToOneDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    // Clean up database tables
	    drivingLicenseRepository.deleteAllInBatch();
	    driverRepository.deleteAllInBatch();

	    //=========================================

	    // Create a Driver instance
		Driver driver = new Driver("Rajeev Kumar Singh", "rajeev@callicoder.com", "+91-9999999999");

		// Create a Driving License instance
		Calendar issueDate = Calendar.getInstance();
		issueDate.set(2017, 7, 21);

		Calendar expiryDate = Calendar.getInstance();
		expiryDate.set(2027, 7, 21);

		DrivingLicense drivingLicense = new DrivingLicense("MH-383321-323-8080", issueDate.getTime(), expiryDate.getTime());

		// Set child reference(drivingLicense) in parent entity(driver)
        driver.setDrivingLicense(drivingLicense);

        // Set parent reference(driver) in child entity(drivingLicense)
        drivingLicense.setDriver(driver);

        // Save Parent Reference (which will save the child as well)
		driverRepository.save(driver);

        //=========================================
	}
}
