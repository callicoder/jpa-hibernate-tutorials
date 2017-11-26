package com.example.hibernate;

import com.example.hibernate.model.Address;
import com.example.hibernate.model.User;
import com.example.hibernate.repository.UserRepository;
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
		// Cleanup database tables.
		userRepository.deleteAll();

        // Insert a user with multiple phone numbers and addresses.
        Set<String> phoneNumbers = new HashSet<>();
		phoneNumbers.add("+91-9999999999");
		phoneNumbers.add("+91-9898989898");

		Set<Address> addresses = new HashSet<>();
		addresses.add(new Address("747", "Golf View Road", "Bangalore",
                "Karnataka", "India", "560008"));
		addresses.add(new Address("Plot No 44", "Electronic City", "Bangalore",
                "Karnataka", "India", "560001"));

		User user = new User("Rajeev Kumar Singh", "rajeev@callicoder.com",
                phoneNumbers, addresses);

		userRepository.save(user);
	}
}
