package com.example.jpa.repository;

import com.example.jpa.model.Employee;
import com.example.jpa.model.EmployeeIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by rajeevkumarsingh on 22/11/17.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeeIdentity> {
    List<Employee> findByEmployeeIdentityCompanyId(String companyId);
}
