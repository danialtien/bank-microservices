package com.danialtien.accounts.service.impl;

import com.danialtien.accounts.dto.CustomerDto;
import com.danialtien.accounts.repository.AccountsRepository;
import com.danialtien.accounts.repository.CustomerRepository;
import com.danialtien.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service @AllArgsConstructor @NoArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;



    @Override
    public void CreateAccount(CustomerDto customerDto) {

    }
}
