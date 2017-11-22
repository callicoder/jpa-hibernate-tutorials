package com.example.hibernateonetoonedemo.repository;

import com.example.hibernateonetoonedemo.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rajeevkumarsingh on 20/11/17.
 */
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
