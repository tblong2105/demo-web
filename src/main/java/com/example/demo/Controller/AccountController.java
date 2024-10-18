package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Account;
import com.example.demo.Repository.AccountRepository;

@RestController("/account")
public class AccountController {
  
  @Autowired
  private AccountRepository accountRepository;
  

  @GetMapping("/all")
  public List<Account> getAll() {
    List<Account> result = accountRepository.findAll();
    return result;
  }
  
}
