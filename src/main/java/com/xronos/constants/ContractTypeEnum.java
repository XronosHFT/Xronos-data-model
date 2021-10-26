package com.xronos.constants;


public enum ContractTypeEnum {

  NONE("NONE"),
  CW("this_week"),
  NW("next_week"),
  CQ("quarter"),
  NQ("next_quarter");
  String value;

  ContractTypeEnum(String value) {
    this.value = value;
  }

  public static ContractTypeEnum parseValue(String contractTypeValue) {
    try {
      for (ContractTypeEnum value : ContractTypeEnum.values()) {
        if (value.value.equals(contractTypeValue)) {
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
