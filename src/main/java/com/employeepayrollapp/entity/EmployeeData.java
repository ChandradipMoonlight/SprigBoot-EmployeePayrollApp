package com.employeepayrollapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class EmployeeData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String imagePath;
    private String gender;
    private int salary;
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name ="id"))
    @Column(name = "department")
    private List<String> department;
    private LocalDate startDate;
    private String notes;

    public EmployeeData() {

    }
}
