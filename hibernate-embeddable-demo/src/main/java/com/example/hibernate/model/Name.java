package com.example.hibernate.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Created by rajeevkumarsingh on 22/11/17.
 */
@Embeddable
public class Name {
    @NotNull
    private String firstName;
    private String middleName;
    private String lastName;

    public Name() {

    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
