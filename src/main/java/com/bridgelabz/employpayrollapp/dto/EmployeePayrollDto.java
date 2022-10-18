package com.bridgelabz.employpayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeePayrollDto {
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name Invalid!")
    @NotEmpty(message = "Employee name cannot be null.")
    public String name;
    @NotEmpty
    @Min(value = 500, message = "minimum wage should be more than 500.")
    public long salary;

}
