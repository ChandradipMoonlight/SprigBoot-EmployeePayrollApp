package com.employeepayrollapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

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
    private LocalDate startDate;
    private String department;
    private String notes;

    public EmployeeData() {

    }
}
