package com.employeepayrollapp.repository;

import com.employeepayrollapp.entity.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpPayRollRepository extends JpaRepository<EmployeeData,Integer> {
}
