package net_banking_api.banking_api.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AccountDto {
    private Long id;
    private int accountNumber;
    private String accountType;
    private String accountHolderName;
    private double accountBalance;

}
