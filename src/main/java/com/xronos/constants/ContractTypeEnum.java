package com.xronos.constants;


public enum ContractTypeEnum {

  NONE("NONE"),
  CW("this_week"),
  NW("next_week"),
  CQ("quarter"),
  NQ("next_quarter"),
  FUTURE("future"),
  SPOT("spot"),
  OPTION("option"),
  SWAP("swap");
  String value;

  ContractTypeEnum(String value) {
    this.value = value;
  }

  public static ContractTypeEnum parseValue(String contractTypeValue) {
    try {
      for (ContractTypeEnum value : ContractTypeEnum.values()) {
        if (value.value.equalsIgnoreCase(contractTypeValue)) {
          return value;
        }
      }
    } catch (Exception ignored) {
    }
    return null;
  }

  public static ContractTypeEnum parseName(String contractTypeName) {
    try {
      return ContractTypeEnum.valueOf(contractTypeName);
    } catch (Exception ignored) {
    }
    return null;
  }
}
