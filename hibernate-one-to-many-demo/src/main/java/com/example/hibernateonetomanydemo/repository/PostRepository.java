package com.example.hibernateonetomanydemo.repository;

import com.example.hibernateonetomanydemo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 21/11/17.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
