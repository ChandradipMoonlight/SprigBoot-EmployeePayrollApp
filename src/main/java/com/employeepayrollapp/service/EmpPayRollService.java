package com.employeepayrollapp.service;

import com.employeepayrollapp.dto.EmpDTO;
import com.employeepayrollapp.entity.EmployeeData;

import java.util.List;

public interface EmpPayRollService {
    EmployeeData createEmployeePayRollData(EmpDTO empDTO);

    List<EmployeeData> getEmployeePayRollData();

    EmployeeData getEmployeePayRollDataById(int empId);

    EmployeeData updateEmployeePayRollDataById(int empId, EmpDTO empDTO);

    EmployeeData deleteEmployeePayRollDataById(int empId);
}
