package com.example.hibernateelementcollectiondemo;

import com.example.hibernateelementcollectiondemo.model.Address;
import com.example.hibernateelementcollectiondemo.model.User;
import com.example.hibernateelementcollectiondemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class HibernateElementCollectionDemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateElementCollectionDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAllInBatch();

		Set<String> phoneNumbers = new HashSet<>();
		phoneNumbers.add("+91-9999999999");
		phoneNumbers.add("+91-9898989898");

		Set<Address> addresses = new HashSet<>();
		addresses.add(new Address("747", "Golf View Road", "Kodihalli", "Bangalore", "India", "560008"));
		addresses.add(new Address("Tower C", "Diamong District", "Domlur", "Bangalore", "India", "560008"));

		User user = new User("Rajeev Kumar Singh", "rajeevs@flock.com", phoneNumbers, addresses);

		userRepository.save(user);
	}
}
