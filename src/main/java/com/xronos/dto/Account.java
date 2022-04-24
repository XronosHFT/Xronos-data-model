package com.xronos.dto;

import com.xronos.constants.ExchangeEnum;
import com.xronos.util.ToolUtil;

public class Account extends AbstractEvent<Account> {

  private static final int MASHALLABLE_VERSION = 1;

  private String accountId;

  private String type;

  private String state;

  private String subType;

  public String accountId() {
    return accountId;
  }

  public String xsAccountId() {
    return ToolUtil.getAccountKey(exchange, accountId);
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

  public String subType() {
    return subType;
  }

  public Account subType(String subType) {
    this.subType = subType;
    return this;
  }

  public Account exchange(ExchangeEnum exchange) {
    this.exchange = exchange;
    return this;
  }
}
