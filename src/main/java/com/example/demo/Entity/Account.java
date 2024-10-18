package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String username;
  
  private String password;

  public Account() {
    // TODO Auto-generated constructor stub
  }
  
  
  
  public Account(String username, String password) {
    super();
    this.username = username;
    this.password = password;
  }



  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  
}
