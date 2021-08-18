package com.employeepayrollapp.service;

import com.employeepayrollapp.dto.EmpDTO;
import com.employeepayrollapp.entity.EmployeeData;
import com.employeepayrollapp.exception.EmployeeDataNotFoundException;
import com.employeepayrollapp.repository.EmpPayRollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class EmpPayRollServiceIML implements EmpPayRollService {

    @Autowired
    EmpPayRollRepository empPayRollRepository;

    /**
     * Purpose: Ability to create or Insert the data into the EmployeePayroll Data;
     * @param empDTO;
     * @return added data into the EmployeePayrollData;
     */
    @Override
    public EmployeeData createEmployeePayRollData(EmpDTO empDTO) {
        log.info("Inside CreateEmployeePayRollData() Method of the EmpPayRollService");
        EmployeeData employeeData = new EmployeeData(empDTO);
        return empPayRollRepository.save(employeeData);
    }

    /**
     *  Purpose : Ability to fetch all employee details from Employee Payroll
     * @return all Employee payroll data;
     */
    @Override
    public List<EmployeeData> getEmployeePayRollData() {
        log.info("Inside getEmployeePayRollData() Method of the EmpPayRollService");
        return empPayRollRepository.findAll();
    }

    /**
     * Purpose : Ability to update employee details in Employee Payroll using ID
     * @param empId;
     * @return employee data;
     */
    @Override
    public EmployeeData getEmployeePayRollDataById(int empId) {
        log.info("Inside getEmployeePayRollDataById() Method of the EmpPayRollService Class!");
        Optional<EmployeeData> employeeData = empPayRollRepository.findById(empId);
        if (employeeData.isEmpty()) {
            throw new EmployeeDataNotFoundException("Employee Data is Not Available");
        }
        return employeeData.get();
    }

    /**
     * Purpose : Ability to update employee details in Employee Payroll using ID
     * @param empId;
     * @param empDTO;
     * @return updated data.
     */

    @Override
    public EmployeeData updateEmployeePayRollDataById(int empId, EmpDTO empDTO) {
        log.info("Inside UpdateEmployeePayrollDataById() Method of EmpPayRollService Class");
        EmployeeData employeeData = empPayRollRepository.findById(empId).get();

        if (Objects.isNull(empDTO)) {
            throw new EmployeeDataNotFoundException("No such Id is present");
        } else if
        (Objects.nonNull(empDTO.getEmpName()) &&
        !"".equalsIgnoreCase(empDTO.getEmpName())) {
        employeeData.setEmpName(empDTO.getEmpName());
        }      employeeData.setEmpSalary(empDTO.getEmpSalary());
        return empPayRollRepository.save(employeeData);
    }

    /**
     * Purpose : Ability to delete employee details from Employee Payroll using ID
     * @param empId;
     * @return deleted successfully;
     */

    @Override
    public EmployeeData deleteEmployeePayRollDataById(int empId) {
        log.info("Inside deleteEmployeePayRollDataById() Method of the EmpPayRollService Class");
        empPayRollRepository.deleteById(empId);
        return null;
    }
}