package com.example.hibernate;

import com.example.hibernate.model.Employee;
import com.example.hibernate.model.EmployeeIdentity;
import com.example.hibernate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateCompositePrimaryKeyDemoApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateCompositePrimaryKeyDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Cleanup employees table
		employeeRepository.deleteAllInBatch();

		// Insert a new Employee in the database
		Employee employee = new Employee(new EmployeeIdentity("E-123", "D-457"),
				"Rajeev Kumar Singh",
				"rajeev@callicoder.com",
				"+91-9999999999");

		employeeRepository.save(employee);

		// Retrieving an Employee Record with the composite primary key
		employeeRepository.findOne(new EmployeeIdentity("E-123", "D-457"));

		// Retrieving all the employees of a particular company
		employeeRepository.findByEmployeeIdentityCompanyId("D-457");
	}
}
