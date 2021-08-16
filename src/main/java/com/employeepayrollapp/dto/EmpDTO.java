package com.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class EmpDTO {

    @Pattern(regexp = "^[A-Z][A-Za-z\\s]{2,}$", message = "Employee Name is Invalid")
    private String empName;

    @Min(value = 5000, message = "Minimum salary should be more than 5000 Rs.")
    private long empSalary;
}
