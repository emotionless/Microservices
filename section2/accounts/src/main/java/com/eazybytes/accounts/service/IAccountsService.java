package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber
     * @return
     */
    CustomerDto fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDto
     * @return boolean
     */
    boolean updateAccount(CustomerDto customerDto);
}
