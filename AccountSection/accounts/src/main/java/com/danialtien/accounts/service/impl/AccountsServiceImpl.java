package com.danialtien.accounts.service.impl;

import com.danialtien.accounts.constant.AccountsConstants;
import com.danialtien.accounts.dto.CustomerDto;
import com.danialtien.accounts.entity.Accounts;
import com.danialtien.accounts.entity.Customer;
import com.danialtien.accounts.exception.CustomerAlreadyExistsException;
import com.danialtien.accounts.mapper.CustomerMapper;
import com.danialtien.accounts.repository.AccountsRepository;
import com.danialtien.accounts.repository.CustomerRepository;
import com.danialtien.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service @AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void CreateAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(new Customer(), customerDto);
        Optional<Customer> existMobilePhone = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(existMobilePhone.isPresent()){
          throw new CustomerAlreadyExistsException("Customer already exist with mobile number " + customer.getMobileNumber());
        }
        Customer saveCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(saveCustomer));
    }

    private Accounts createNewAccount(Customer customer){
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }
}
