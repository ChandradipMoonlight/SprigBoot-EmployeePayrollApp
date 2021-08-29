package com.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Data
public class EmpDTO {

    private int id;

    @Pattern(regexp = "^[A-Z][A-Za-z\\s]{2,}$", message = "Employee Name is Invalid")
    private String name;

    private String imagePath;

    private String gender;

    @Min(value = 5000, message = "Minimum salary should be more than 5000 Rs.")
    private int salary;

//    @JsonFormat(pattern = "dd MMM yyyy")
//    @NotNull(message = "StartDate should not be Empty")
//    @PastOrPresent(message = "StartDate should be past or today's date")
    private LocalDate startDate;
//    @ElementCollection
//    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name ="id"))
//    @Column(name = "department")
    private List<String> department;
    private String notes;
}
