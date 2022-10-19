package com.bridgelabz.employpayrollapp.model;

import com.bridgelabz.employpayrollapp.dto.EmployeePayrollDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;


    public EmployeePayrollData(int empId, EmployeePayrollDto employeePayrollDto)
    {
        this.employeeId = empId;
        this.name = employeePayrollDto.getName();
        this.salary = employeePayrollDto.getSalary();
        this.gender = employeePayrollDto.getGender();
        this.note = employeePayrollDto.getNote();
        this.startDate = employeePayrollDto.getStartDate();
        this.profilePic = employeePayrollDto.getProfilePic();
        this.departments = employeePayrollDto.getDepartments();

    }
}
