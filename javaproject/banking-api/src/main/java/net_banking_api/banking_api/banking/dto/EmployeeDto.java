package net_banking_api.banking_api.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {
    private Long id;
    private String name;
    private String dateOfBirth;
    private String phoneNumber;
    private String email;

}
