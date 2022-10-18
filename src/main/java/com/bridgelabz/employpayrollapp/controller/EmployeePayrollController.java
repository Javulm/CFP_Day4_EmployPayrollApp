package com.bridgelabz.employpayrollapp.controller;

import com.bridgelabz.employpayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employpayrollapp.dto.ResponseDto;
import com.bridgelabz.employpayrollapp.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class EmployeePayrollController {
    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDto> getEmployeePayrollData() {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDto("Javul", 40000));
        ResponseDto respDTO = new ResponseDto("Get Call Success", employeePayrollData);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empId -employee id
     * show Employee data by id using get mapping
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(2, new EmployeePayrollDto("Akash", 50000));
        ResponseDto respDTO = new ResponseDto("Get Call Success", employeePayrollData);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empPayrollDto
     * Creating employee data using Post mapping
     */
    @PostMapping(path = "/create", consumes = {"application/json"})
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@RequestBody EmployeePayrollDto empPayrollDto) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, empPayrollDto);
        ResponseDto respDTO = new ResponseDto("Created Employee Data ", empPayrollDto);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empId - employee id
     * @param empPayrollDto
     * Updating employee data using path variable and request body by put method
     */
    @PutMapping(path = "/update/{empId}", consumes = {"application/json"})
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@PathVariable("empId") int empId, @RequestBody EmployeePayrollDto empPayrollDto) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empId, empPayrollDto);
        ResponseDto respDTO = new ResponseDto("Updated Employee payroll Data : ", empPayrollDto);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empId
     * Deleting employee data by employee id through path variable using delete method
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        ResponseDto respDTO = new ResponseDto("Deleted Employee Data ", empId);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }
}
