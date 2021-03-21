package com.xronos.dto;

import java.util.List;

public class Account extends AbstractEvent<Account> {

  private static final int MASHALLABLE_VERSION = 1;

  private String accountId;

  private String type;

  private String state;

  private List<Balance> list;

  private String subType;

  public String accountId() {
    return accountId;
  }

  public Account accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  public String type() {
    return type;
  }

  public Account type(String type) {
    this.type = type;
    return this;
  }

  public String state() {
    return state;
  }

  public Account state(String state) {
    this.state = state;
    return this;
  }

  public List<Balance> list() {
    return list;
  }

  public Account list(List<Balance> list) {
    this.list = list;
    return this;
  }

  public String subType() {
    return subType;
  }

  public Account subType(String subType) {
    this.subType = subType;
    return this;
  }
}
