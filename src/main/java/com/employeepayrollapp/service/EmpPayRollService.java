package com.employeepayrollapp.service;

import com.employeepayrollapp.dto.EmpDTO;
import com.employeepayrollapp.entity.EmployeeData;
import com.employeepayrollapp.exception.EmployeeDataNotFoundException;

import java.util.List;

public interface EmpPayRollService {
    EmployeeData createEmployeePayRollData(EmpDTO empDTO);

    List<EmployeeData> getEmployeePayRollData();

    EmployeeData getEmployeePayRollDataById(int empId) throws EmployeeDataNotFoundException;

    EmployeeData updateEmployeePayRollDataById(int empId, EmpDTO empDTO) throws EmployeeDataNotFoundException;

    EmployeeData deleteEmployeePayRollDataById(int empId);
}
