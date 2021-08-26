package com.employeepayrollapp.controller;

import com.employeepayrollapp.dto.EmpDTO;
import com.employeepayrollapp.dto.ResponseDTO;
import com.employeepayrollapp.entity.EmployeeData;
import com.employeepayrollapp.exception.EmployeeDataNotFoundException;
import com.employeepayrollapp.service.EmpPayRollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
@Slf4j
public class EmpPayRollController {

    @Autowired
    EmpPayRollService empPayRollService;

    /**
     * Purpose : Ability to add employee details in Employee Payroll service.
     * @param empDTO this is Object of EmpDTO class
     * @return responseDTO
     */

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayRollData(@Valid @RequestBody EmpDTO empDTO) {
        EmployeeData employeeData = empPayRollService.createEmployeePayRollData(empDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data Successfully!", employeeData);
        log.info("Inside CreateEmployeePayRollData of EmpPayRollController");
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    /**
     * Purpose: Ability to get all Employee Payroll data.
     * @return employee data;
     */
    @GetMapping(value = {"/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayRollData() {
        log.info("Inside getEmployeePayrollData of EmpPayRollControl");
        List<EmployeeData> employeeDataList = empPayRollService.getEmployeePayRollData();
        ResponseDTO responseDTO = new ResponseDTO("Retrieved Data Successfully!", employeeDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose: Ability to get Employee Details by Using the ID.
     * @param empId;
     * @return Employee data.
     */
    @GetMapping("/getById/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayRollDataByID(@PathVariable("empId")
                                                                              int empId) throws EmployeeDataNotFoundException {
        log.info("Inside getEmployeePayRollData() Method of the Class EmpPayRollController");
        EmployeeData employeeData = empPayRollService.getEmployeePayRollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Employee Data Fetched Successfully By Using Id", employeeData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose: Ability to update existing data with new details by using ID;
     * @param empId;
     * @param empDTO;
     * @return Updated Employee Data.
     */
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayRollDataById(@PathVariable("empId") int empId,
                                                             @Valid  @RequestBody EmpDTO empDTO) throws EmployeeDataNotFoundException{
        log.info("Inside updateEmployeePayRollDataById() Method of the EmpPayRollController");
        EmployeeData employeeData = empPayRollService.updateEmployeePayRollDataById(empId, empDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee Data Updated Successfully!!", employeeData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose: Ability to delete the existing employee data.
     * @param empId;
     * @return deleted.
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayRollDataById(@PathVariable("empId") int empId) {
        log.info("Inside deleteEmployeePayRollDatById() Method of the EmpPayRollController");
        EmployeeData employeeData = empPayRollService.deleteEmployeePayRollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully!!", employeeData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
