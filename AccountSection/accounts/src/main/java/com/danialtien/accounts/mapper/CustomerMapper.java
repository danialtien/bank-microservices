package com.danialtien.accounts.mapper;

import com.danialtien.accounts.dto.CustomerDto;
import com.danialtien.accounts.entity.Customer;

import java.time.LocalDateTime;

public class CustomerMapper {

    public static Customer mapToCustomer(Customer customer, CustomerDto customerDto) {
        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());
        customer.setMobileNumber(customerDto.getMobileNumber());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        return customer;
    }

    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto){
        customerDto.setEmail(customer.getEmail());
        customerDto.setName(customer.getName());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }
}
