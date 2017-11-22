package com.example.hibernate.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by rajeevkumarsingh on 22/11/17.
 */
@Entity
@Table(name = "employees")
public class Employee {

    @EmbeddedId
    private EmployeeIdentity identity;

    @NotNull
    private String name;

    @NotNull
    @Size(max = 100)
    private String email;

    @Size(max = 15)
    private String phoneNumber;

    public Employee() {

    }

    public Employee(EmployeeIdentity identity, String name, String email, String phoneNumber) {
        this.identity = identity;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public EmployeeIdentity getIdentity() {
        return identity;
    }

    public void setIdentity(EmployeeIdentity identity) {
        this.identity = identity;
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
