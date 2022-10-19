package com.bridgelabz.employpayrollapp.model;

import com.bridgelabz.employpayrollapp.dto.EmployeePayrollDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name = "employee_payroll")
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;

    public EmployeePayrollData (EmployeePayrollDto employeePayrollDto){
        this.UpdateEmployeePayrollData(employeePayrollDto);
    }

    public void UpdateEmployeePayrollData(EmployeePayrollDto employeePayrollDto)
    {
        this.name = employeePayrollDto.getName();
        this.salary = employeePayrollDto.getSalary();
        this.gender = employeePayrollDto.getGender();
        this.note = employeePayrollDto.getNote();
        this.startDate = employeePayrollDto.getStartDate();
        this.profilePic = employeePayrollDto.getProfilePic();
        this.departments = employeePayrollDto.getDepartments();

    }
}
