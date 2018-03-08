package com.example.jpa.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rajeevkumarsingh on 22/11/17.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    @ElementCollection
    @CollectionTable(name = "user_phone_numbers", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "phone_number")
    private Set<String> phoneNumbers = new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_addresses", joinColumns = @JoinColumn(name = "user_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
    })
    private Set<Address> addresses = new HashSet<>();


    public User() {

    }

    public User(String name, String email, Set<String> phoneNumbers, Set<Address> addresses) {
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
