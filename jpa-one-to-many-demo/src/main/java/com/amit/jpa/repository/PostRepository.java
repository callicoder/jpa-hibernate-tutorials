package com.amit.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.jpa.model.Post;
/**
*
* @author Amit Patil
*
**/
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
