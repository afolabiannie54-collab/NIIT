package net_banking_api.banking_api.banking.mapper;


import net_banking_api.banking_api.banking.dto.EmployeeDto;

import net_banking_api.banking_api.banking.entity.Employee;

public class EmployeeMapper {
 public static Employee mapToEmployee(EmployeeDto employeeDto){

        Employee employee = new Employee(
            employeeDto.getId(),
            employeeDto.getName(),
            employeeDto.getDateOfBirth(),
            employeeDto.getPhoneNumber(),
            employeeDto.getEmail()
        );

        return employee;

    }

      public static EmployeeDto mapToEmployeeDto(Employee employee){

        EmployeeDto employeeDto = new EmployeeDto(
            employee.getId(),
            employee.getName(),
            employee.getDateOfBirth(),
            employee.getPhoneNumber(),
            employee.getEmail()
        );

        return employeeDto;

    }
}
