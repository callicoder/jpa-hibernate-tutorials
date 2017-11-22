package com.example.hibernatemanytomanydemo;

import com.example.hibernatemanytomanydemo.model.Course;
import com.example.hibernatemanytomanydemo.model.Student;
import com.example.hibernatemanytomanydemo.repository.CourseRepository;
import com.example.hibernatemanytomanydemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class HibernateManyToManyDemoApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateManyToManyDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentRepository.deleteAllInBatch();
		courseRepository.deleteAllInBatch();

		// Create a Student
		Student student = studentRepository.save(new Student("Rajeev Kumar Singh", "rajeev@callicoder.com"));

		// Create a Course
		Calendar courseStartDate = Calendar.getInstance();
		Calendar courseEndDate = Calendar.getInstance();
		courseEndDate.add(Calendar.MONTH, 6);
		Course course = courseRepository.save(new Course("Algorithms 101", courseStartDate.getTime(), courseEndDate.getTime()));

		// Enrol the Student in the Course
		student.getCourses().add(course);
		studentRepository.save(student);
	}
}
