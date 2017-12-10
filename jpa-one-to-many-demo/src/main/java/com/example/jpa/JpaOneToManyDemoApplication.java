package com.example.jpa;

import com.example.jpa.model.Comment;
import com.example.jpa.model.Post;
import com.example.jpa.repository.CommentRepository;
import com.example.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaOneToManyDemoApplication implements CommandLineRunner {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToManyDemoApplication.class, args);
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

		Comment comment1 = new Comment("Great Post!");
		comment1.setPost(post);

		Comment comment2 = new Comment("Really helpful Post. Thanks a lot!");
		comment2.setPost(post);

		post.getComments().add(comment1);
		post.getComments().add(comment2);

		postRepository.save(post);

		// ======================================

	}
}
