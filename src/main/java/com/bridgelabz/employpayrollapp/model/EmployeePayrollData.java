package com.bridgelabz.employpayrollapp.model;

import com.bridgelabz.employpayrollapp.dto.EmployeePayrollDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData(int empId, EmployeePayrollDto employeePayrollDto)
    {
        this.employeeId = empId;
        this.name = employeePayrollDto.getName();
        this.salary = employeePayrollDto.getSalary();
    }
}
