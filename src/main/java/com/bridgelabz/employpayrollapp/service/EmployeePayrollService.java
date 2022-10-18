package com.bridgelabz.employpayrollapp.service;

import com.bridgelabz.employpayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employpayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = new ArrayList<>();
        empDataList.add(new EmployeePayrollData(1, new EmployeePayrollDto("Javul", 550000)));
        return empDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, new EmployeePayrollDto("Javul", 550000));
        return empData;
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto empPayrollDto) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, empPayrollDto);
        return empData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDto empPayrollDto) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, empPayrollDto);
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {

    }
}
