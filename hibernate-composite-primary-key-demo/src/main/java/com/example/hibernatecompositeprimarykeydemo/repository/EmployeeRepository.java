package com.example.hibernatecompositeprimarykeydemo.repository;

import com.example.hibernatecompositeprimarykeydemo.model.Employee;
import com.example.hibernatecompositeprimarykeydemo.model.EmployeeIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 22/11/17.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeeIdentity> {
}
