package com.xronos.constants;


public enum TradeModeEnum {
  NONE("none"),
  CASH("cash"), // 逐仓杠杆
  ISOLATED("isolated"), //逐仓杠杆
  CROSS("cross"); //全仓币币

  String value;

  TradeModeEnum(String value) {
    this.value = value;
  }

  public static TradeModeEnum parseValue(String contractTypeValue) {
    try {
      for (TradeModeEnum value : TradeModeEnum.values()) {
        if (value.value.equalsIgnoreCase(contractTypeValue)) {
          return value;
        }
      }
    } catch (Exception ignored) {
    }
    return TradeModeEnum.NONE;
  }

  public static TradeModeEnum parseName(String contractTypeName) {
    try {
      return TradeModeEnum.valueOf(contractTypeName);
    } catch (Exception ignored) {
    }
    return TradeModeEnum.NONE;
  }

  public String value() {
    return value;
  }
}
