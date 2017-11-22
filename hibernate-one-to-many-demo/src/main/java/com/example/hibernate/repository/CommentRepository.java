package com.example.hibernate.repository;

import com.example.hibernate.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 21/11/17.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
