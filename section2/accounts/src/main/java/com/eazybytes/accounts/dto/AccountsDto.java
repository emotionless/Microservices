package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {
    @NotEmpty(message = "Account number should not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number should be exactly 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "Account type should not be empty")
    private String accountType;

    @NotEmpty(message = "Branch address should not be empty")
    private String branchAddress;
}
