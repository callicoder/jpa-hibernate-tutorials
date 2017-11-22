package com.example.hibernatecompositeprimarykeydemo;

import com.example.hibernatecompositeprimarykeydemo.model.Employee;
import com.example.hibernatecompositeprimarykeydemo.model.EmployeeIdentity;
import com.example.hibernatecompositeprimarykeydemo.repository.EmployeeRepository;
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
		employeeRepository.deleteAllInBatch();

		Employee employee = new Employee(new EmployeeIdentity("E-123", "D-457"), "Rajeev Kumar Singh", "rajeev@callicoder.com", "+91-9999999999");

		employeeRepository.save(employee);
	}
}
