package com.example.hibernateonetomanydemo.repository;

import com.example.hibernateonetomanydemo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 21/11/17.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
