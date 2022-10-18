package com.bridgelabz.employpayrollapp.service;

import com.bridgelabz.employpayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employpayrollapp.model.EmployeePayrollData;
import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto empPayrollDto);

    EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDto empPayrollDto);

    void deleteEmployeePayrollData(int empId);
}