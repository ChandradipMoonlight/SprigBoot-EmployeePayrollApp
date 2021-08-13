package com.employeepayrollapp.dto;

import com.employeepayrollapp.entity.EmployeeData;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;
}
