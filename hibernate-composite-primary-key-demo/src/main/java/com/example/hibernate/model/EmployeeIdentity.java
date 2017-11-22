package com.example.hibernate.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by rajeevkumarsingh on 22/11/17.
 */
@Embeddable
public class EmployeeIdentity implements Serializable {
    @NotNull
    private String employeeCode;

    @NotNull
    private String companyCode;

    public EmployeeIdentity() {

    }

    public EmployeeIdentity(String employeeCode, String companyCode) {
        this.employeeCode = employeeCode;
        this.companyCode = companyCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeIdentity that = (EmployeeIdentity) o;

        if (!employeeCode.equals(that.employeeCode)) return false;
        return companyCode.equals(that.companyCode);
    }

    @Override
    public int hashCode() {
        int result = employeeCode.hashCode();
        result = 31 * result + companyCode.hashCode();
        return result;
    }
}
