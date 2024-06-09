package com.danialtien.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("sayhello")
    public String sayHello() {
        return "Hi World!";
    }
}
