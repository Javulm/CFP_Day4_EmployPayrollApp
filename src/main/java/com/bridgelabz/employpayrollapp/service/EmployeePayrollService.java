package com.bridgelabz.employpayrollapp.service;

import com.bridgelabz.employpayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employpayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employpayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return  employeePayrollList.stream().filter(empData ->empData.getEmployeeId() == empId).findFirst().orElseThrow(() -> new EmployeePayrollException("Employee not found"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto empPayrollDto) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(employeePayrollList.size()+1, empPayrollDto);
        employeePayrollList.add(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto empPayrollDto) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.setName(empPayrollDto.getName());
        empData.setSalary(empPayrollDto.getSalary());
        employeePayrollList.set(empId-1, empData);
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.remove(empId-1);
    }
}
