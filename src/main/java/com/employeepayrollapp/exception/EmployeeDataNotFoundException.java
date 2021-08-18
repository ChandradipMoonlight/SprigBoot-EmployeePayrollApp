package com.employeepayrollapp.exception;

public class EmployeeDataNotFoundException extends RuntimeException{
    public EmployeeDataNotFoundException() {
        super();
    }

    public EmployeeDataNotFoundException(String message) {
        super(message);
    }

    public EmployeeDataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeDataNotFoundException(Throwable cause) {
        super(cause);
    }

    protected EmployeeDataNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

