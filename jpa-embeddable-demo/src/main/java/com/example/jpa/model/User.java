package com.example.jpa.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by rajeevkumarsingh on 22/11/17.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Name name;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @Embedded
    @AttributeOverrides(value = {
        @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
        @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
    })
    private Address address;

    public User() {

    }

    public User(Name name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
