package com.bridgelabz.employpayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeePayrollDto {
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name Invalid!")
    @NotEmpty(message = "Employee name cannot be null.")
    private String name;

    @NotNull(message = "salary Should not be Empty")
    @Max(value = 1000000, message = "maximum wage should not exceed than 1000000")
    @Min(value = 500, message = "minimum wage should be more than 500.")
    private long salary;

    @Pattern(regexp = "male|female", message = "Gender Needs to be Male or Female")
    private String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "startDate Should not be Empty")
    @PastOrPresent(message = "startDate Should not be past or present Date")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "Profile Pic should not be Empty")
    private String profilePic;

    @NotNull(message = "department should not be Empty")
    private List<String> departments;

}
