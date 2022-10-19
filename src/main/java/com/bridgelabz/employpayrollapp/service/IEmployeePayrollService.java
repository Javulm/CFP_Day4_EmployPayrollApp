package com.bridgelabz.employpayrollapp.service;

import com.bridgelabz.employpayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employpayrollapp.model.EmployeePayrollData;
import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);
    List<EmployeePayrollData> findEmployeesByDepartment(String department);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto empPayrollDto);

    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto empPayrollDto);

    void deleteEmployeePayrollData(int empId);
}
