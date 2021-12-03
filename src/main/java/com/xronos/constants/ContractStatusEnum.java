package com.xronos.constants;


public enum ContractStatusEnum {

  NONE("NONE"),
  ACTIVE("active"),
  SUSPEND("suspend"),
  EXPIRED("expired"),
  PREOPEN("preopen");
  String value;

  ContractStatusEnum(String value) {
    this.value = value;
  }

  public static ContractStatusEnum parseValue(String contractTypeValue) {
    try {
      for (ContractStatusEnum value : ContractStatusEnum.values()) {
        if (value.value.equalsIgnoreCase(contractTypeValue)) {
          return value;
        }
      }
    } catch (Exception ignored) {
    }
    return null;
  }

  public static ContractStatusEnum parseName(String contractTypeName) {
    try {
      return ContractStatusEnum.valueOf(contractTypeName);
    } catch (Exception ignored) {
    }
    return null;
  }

  public String value() {
    return value;
  }
}
