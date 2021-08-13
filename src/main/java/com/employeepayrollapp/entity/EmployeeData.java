package com.employeepayrollapp.entity;

import com.employeepayrollapp.dto.EmpDTO;
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
    private int empId;
    private String empName;
    private long empSalary;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public EmployeeData(EmpDTO empDTO) {
        this.empName=empDTO.getEmpName();
        this.empSalary=empDTO.getEmpSalary();
        this.createdDate=LocalDate.now();
        this.updatedDate=LocalDate.now();
    }

    public EmployeeData() {

    }
}
