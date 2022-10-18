package com.bridgelabz.employpayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployPayrollAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployPayrollAppApplication.class, args);
        log.info("Employee payroll app started {} Environment", context.getEnvironment().getProperty("environment"));
    }
}
