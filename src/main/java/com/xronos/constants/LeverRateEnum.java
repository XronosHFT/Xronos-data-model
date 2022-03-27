package com.xronos.constants;

import java.util.HashMap;
import java.util.Map;

public enum LeverRateEnum {

  NONE("0"),
  LEVER_RATE_1("1"),
  LEVER_RATE_2("2"),
  LEVER_RATE_3("3"),
  LEVER_RATE_5("5"),
  LEVER_RATE_10("10"),
  LEVER_RATE_20("20"),
  LEVER_RATE_30("30"),
  LEVER_RATE_50("50"),
  LEVER_RATE_70("70"),
  LEVER_RATE_75("75"),
  LEVER_RATE_100("100"),
  LEVER_RATE_125("125");

  private final String lever;


  private static final Map<String, LeverRateEnum> ENUM_MAP = new HashMap<>();

  static {
    for (LeverRateEnum instance : LeverRateEnum.values()) {
      ENUM_MAP.put(instance.getValue(), instance);
    }
  }

  LeverRateEnum(String lever) {
    this.lever = lever;
  }

  public String getValue() {
    return lever;
  }

  public static LeverRateEnum get(String lever) {
    return ENUM_MAP.get(lever);
  }

  public static void main(String[] args) {
    LeverRateEnum leverRateEnum = LeverRateEnum.get("1");
    System.out.println(leverRateEnum);
  }
}
