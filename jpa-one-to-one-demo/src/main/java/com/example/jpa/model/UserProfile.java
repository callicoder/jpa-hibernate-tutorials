package com.example.jpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by rajeevkumarsingh on 20/11/17.
 */
@Entity
@Table(name = "user_profiles")
@Data
@NoArgsConstructor
public class UserProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date dateOfBirth;

    private String address1;

    private String address2;

    private String street;

    private String city;

    private String state;

    private String country;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public UserProfile(String phoneNumber, Gender gender, Date dateOfBirth,
                       String address1, String address2, String street, String city,
                       String state, String country, String zipCode) {
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address1 = address1;
        this.address2 = address2;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }
}
