package com.xronos.constants;

public enum TimerTypeEnum {

  _1_SEC("1"),
  _10_SEC("10"),
  _1_MIN("1"),
  _15_MIN("15"),
  _30_MIN("30"),
  _60_MIN("60"),
  _240_MIN("240");

  private final String secs;

  TimerTypeEnum(String secs) {
    this.secs = secs;
  }

  public String getValue() {
    return secs;
  }
}
