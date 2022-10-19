package com.bridgelabz.employpayrollapp.service;

import com.bridgelabz.employpayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employpayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employpayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employpayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{
    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return  employeePayrollRepository.findById(empId).orElseThrow(()-> new EmployeePayrollException("Employee with id "+ empId+ "does no exists"));
    }

    @Override
    public List<EmployeePayrollData> findEmployeesByDepartment(String department) {
        return employeePayrollRepository.findEmployeesByDepartment(department);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto empPayrollDto) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empPayrollDto);
        log.debug("EmpData: " + empData.toString());
        return employeePayrollRepository.save(empData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto empPayrollDto) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.UpdateEmployeePayrollData(empPayrollDto);
        return employeePayrollRepository.save(empData);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(empData);
    }
}
