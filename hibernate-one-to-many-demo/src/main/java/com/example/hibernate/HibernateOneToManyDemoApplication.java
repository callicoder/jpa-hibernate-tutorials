package com.example.hibernate;

import com.example.hibernate.model.Comment;
import com.example.hibernate.model.Post;
import com.example.hibernate.repository.CommentRepository;
import com.example.hibernate.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateOneToManyDemoApplication implements CommandLineRunner {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateOneToManyDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Cleanup Database tables
		commentRepository.deleteAllInBatch();
		postRepository.deleteAllInBatch();

		// ======================================

		Post post = new Post("Hibernate One-To-Many Mapping Example",
				"Learn how to use one to many mapping in hibernate",
				"Entire Post Content with sample code");

		Comment comment1 = new Comment("Greate Post!");
		comment1.setPost(post);

		Comment comment2 = new Comment("Really helpful Post. Thanks a lot!");
		comment2.setPost(post);

		post.getComments().add(comment1);
		post.getComments().add(comment2);

		postRepository.save(post);

		// ======================================

	}
}
