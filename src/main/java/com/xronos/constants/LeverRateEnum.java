package com.xronos.constants;

public enum LeverRateEnum {

  LEVER_RATE_1(1),
  LEVER_RATE_2(2),
  LEVER_RATE_3(3),
  LEVER_RATE_5(5),
  LEVER_RATE_10(10),
  LEVER_RATE_20(20),
  LEVER_RATE_30(30),
  LEVER_RATE_50(50),
  LEVER_RATE_70(70),
  LEVER_RATE_75(75),
  LEVER_RATE_100(100),
  LEVER_RATE_125(125);

  private final int lever;

  LeverRateEnum(int lever) {
    this.lever = lever;
  }

  public int getValue() {
    return lever;
  }
}
