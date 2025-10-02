package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer, Account, Card, Loan information"
)
public class CustomerDetailsDto {
    @Schema(
            description = "Name of the customer", example = "Faruk Hossain"
    )
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 5, max = 30, message = "Name should be between 5 and 30 characters")
    private String name;


    @Schema(
            description = "Email of the customer", example = "miloniitju@gmail.com"
    )
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;


    @Schema(
            description = "Mobile number of the customer", example = "1924951639"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be exactly 10 digits")
    private String mobileNumber;


    @Schema(
            description = "Account of the customer"
    )
    private AccountsDto accountsDto;

    @Schema(
            description = "Loans details of the customer"
    )
    private LoansDto loansDto;

    @Schema(
            description = "Cards details of the customer"
    )
    private CardsDto cardsDto;
}
