package com.example.jpa.model;

import org.hibernate.annotations.NaturalId;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by rajeevkumarsingh on 22/11/17.
 */
@Entity
@Table(name = "employees")
public class Employee {

    @EmbeddedId
    private EmployeeIdentity employeeIdentity;

    @NotNull
    @Size(max = 60)
    private String name;

    @NaturalId
    @NotNull
    @Email
    @Size(max = 60)
    private String email;

    @Size(max = 15)
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    public Employee() {

    }

    public Employee(EmployeeIdentity employeeIdentity, String name, String email, String phoneNumber) {
        this.employeeIdentity = employeeIdentity;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public EmployeeIdentity getEmployeeIdentity() {
        return employeeIdentity;
    }

    public void setEmployeeIdentity(EmployeeIdentity employeeIdentity) {
        this.employeeIdentity = employeeIdentity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
