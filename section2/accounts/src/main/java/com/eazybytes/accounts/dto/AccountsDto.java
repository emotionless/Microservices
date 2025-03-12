package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold account information of the customer"
)
public class AccountsDto {

    @Schema(
            description = "Account number of the Eazy Bank account", example = "1234567890"
    )
    @NotEmpty(message = "Account number should not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number should be exactly 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "Account type should not be empty")

    @Schema(
            description = "Account type of Eazy Bank account", example = "Saving"
    )
    private String accountType;

    @NotEmpty(message = "Branch address should not be empty")
    @Schema(
            description = "Eazy Bank branch address", example = "123 East Georgia Street"
    )
    private String branchAddress;
}
