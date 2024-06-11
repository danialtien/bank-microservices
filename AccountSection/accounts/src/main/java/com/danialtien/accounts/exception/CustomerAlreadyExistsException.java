package com.danialtien.accounts.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CustomerAlreadyExistsException extends RuntimeException {

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
