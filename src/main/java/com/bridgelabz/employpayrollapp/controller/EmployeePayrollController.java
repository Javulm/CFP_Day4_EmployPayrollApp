package com.bridgelabz.employpayrollapp.controller;

import com.bridgelabz.employpayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employpayrollapp.dto.ResponseDto;
import com.bridgelabz.employpayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employpayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/home")
public class EmployeePayrollController {
    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /**
     * show all employee data in the list
     * @return employee data list
     */
    @GetMapping(value = {"", "/", "/getall"})
    public ResponseEntity<ResponseDto> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDto respDTO = new ResponseDto("Get Call Success", empDataList);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empId -employee id
     * show Employee data by id using get mapping
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDto respDTO = new ResponseDto("Get Call for Id Successfully", empData);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empPayrollDto
     * Creating employee data using Post mapping
     */
    @PostMapping(path = "/create", consumes = {"application/json"})
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDto empPayrollDto) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(empPayrollDto);
        ResponseDto respDTO = new ResponseDto("Created Employee Payroll Data successfully", empData);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empId - employee id
     * @param empPayrollDto
     * Updating employee data using path variable and request body by put method
     */
    @PutMapping(path = "/update/{empId}", consumes = {"application/json"})
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@PathVariable("empId") int empId, @Valid @RequestBody EmployeePayrollDto empPayrollDto) {
       EmployeePayrollData employeePayrollData = null;
       employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDto);
       ResponseDto respDTO = new ResponseDto("Updated Employee payroll data successfully",employeePayrollData);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }

    /**
     *
     * @param empId
     * Deleting employee data by employee id through path variable using delete method
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDto respDTO = new ResponseDto("Deleted Successfully", "Deleted id: " +empId);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }
}
