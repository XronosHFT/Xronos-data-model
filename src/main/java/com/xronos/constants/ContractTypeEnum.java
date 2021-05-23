package com.xronos.constants;


public enum ContractTypeEnum {

  NONE("NONE"),
  CW("current_week"),
  NW("next_week"),
  CQ("current_quarter"),
  NQ("next_quarter");
  String value;

  ContractTypeEnum(String value) {
    this.value = value;
  }
}
