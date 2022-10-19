package com.bridgelabz.employpayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeePayrollDto {
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name Invalid!")
    @NotEmpty(message = "Employee name cannot be null.")
    private String name;
    @Max(value = 1000000, message = "maximum wage should not exceed than 1000000")
    @Min(value = 500, message = "minimum wage should be more than 500.")
    private long salary;

}
