package com.danialtien.accounts.service;

import com.danialtien.accounts.dto.CustomerDto;

public interface IAccountsService {

    void CreateAccount(CustomerDto customerDto);
}
